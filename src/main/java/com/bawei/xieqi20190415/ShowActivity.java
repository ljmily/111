package com.bawei.xieqi20190415;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class ShowActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        imageView = findViewById(R.id.img);
        textView = findViewById(R.id.name);
        SharedPreferences spa = getSharedPreferences("user",MODE_PRIVATE);
        String name = spa.getString("name","");
        String picture = spa.getString("picture","");
        RoundedCorners roundedCorners= new RoundedCorners(100);
        RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(120, 120);
        Glide.with(ShowActivity.this).load(picture).apply(options).into(imageView);
        textView.setText(name);
        TextView textView7 = findViewById(R.id.title);
        TextView view = findViewById(R.id.fanhui);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView7.setText("用户资料");
    }
}
