package com.bawei.xieqi20190415;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.xieqi20190415.bean.JavaBean;
import com.bawei.xieqi20190415.mvp.model.MainModelIml;
import com.bawei.xieqi20190415.mvp.presenter.MainPresenterIml;
import com.bawei.xieqi20190415.mvp.view.MainView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText editText;
    private EditText editText1;
    private TextView textView;
    private Button button;
    private MainPresenterIml mainPresenterIml;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit1);
        editText1 = findViewById(R.id.edit2);
        textView = findViewById(R.id.ljzc);
        button = findViewById(R.id.button);
        sp = getSharedPreferences("user",MODE_PRIVATE);
        mainPresenterIml = new MainPresenterIml(new MainModelIml(),this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                denglu();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ZhuceActivity.class));
            }
        });


    }

    private void denglu() {
        String username = editText.getText().toString().trim();
        String password = editText1.getText().toString().trim();
        if (username.isEmpty()||password.isEmpty()){
            Toast.makeText(MainActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
        }
        mainPresenterIml.doLogin(username,password);
    }

    @Override
    public void success(String data) {
        JavaBean bean = new Gson().fromJson(data,JavaBean.class);
        JavaBean.ResultBean resultBean = bean.getResult();
        sp.edit().putString("picture",resultBean.getHeadPic()).putString("name",resultBean.getNickName()).commit();

        if (bean.getStatus().equals("0000")){
            Toast.makeText(MainActivity.this,bean.getMessage(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,ShowActivity.class));
        }else  if (bean.getStatus().equals("1001")){
            Toast.makeText(MainActivity.this,bean.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail(String error) {
        JavaBean bean = new Gson().fromJson(error,JavaBean.class);
        JavaBean.ResultBean resultBean = bean.getResult();
        if (bean.getStatus().equals("1001")){
            Toast.makeText(MainActivity.this,bean.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
