package com.bawei.xieqi20190415;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.xieqi20190415.bean.JsonBean;
import com.bawei.xieqi20190415.mvp.model.MainModelIml;
import com.bawei.xieqi20190415.mvp.presenter.MainPresenterIml;
import com.bawei.xieqi20190415.mvp.view.MainView;
import com.google.gson.Gson;

public class ZhuceActivity extends AppCompatActivity implements MainView {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Button button;
    private MainPresenterIml mainPresenterIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        editText = findViewById(R.id.edit00);
        editText1 = findViewById(R.id.edit01);
        editText2 = findViewById(R.id.edit02);
        textView = findViewById(R.id.jxdl);
        button = findViewById(R.id.jc);
        TextView textView7 = findViewById(R.id.title);
        TextView view = findViewById(R.id.fanhui);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView7.setText("注册");
        mainPresenterIml = new MainPresenterIml(new MainModelIml(),this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuce();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void zhuce() {
        String username = editText.getText().toString().trim();
        String password = editText1.getText().toString().trim();
        String password1 = editText2.getText().toString().trim();
        if (username.isEmpty()||password.isEmpty()||password1.isEmpty()){
           Toast.makeText(ZhuceActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
        }else if (!password.equals(password1)){
            Toast.makeText(ZhuceActivity.this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
        }else{
            mainPresenterIml.doRegiset(username,password1);
        }


    }

    @Override
    public void success(String data) {
        JsonBean bean2 = new Gson().fromJson(data,JsonBean.class);
        String bean1 = bean2.getStatus();
        String message = bean2.getMessage();
        if (bean1.equals("0000")){
            Toast.makeText(ZhuceActivity.this,message,Toast.LENGTH_SHORT).show();
            finish();
        }else  if (bean1.equals("1001")){
            Toast.makeText(ZhuceActivity.this,message,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fail(String error) {

    }
}
