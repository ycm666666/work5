package com.ycm.work5.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.ycm.work5.R;
import android.os.Handler;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdActivity extends AppCompatActivity{
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.tv_image)
    ImageView tv_image;
    @BindView(R.id.tv_root)
    RelativeLayout tv_root;
    @BindString(R.string.app_name)
    String str;
    @BindColor(R.color.colorAccent)
    int col;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };
@OnClick({R.id.tv_count,R.id.tv_image})
    public void startMainActivity(View view){
    if(view.getId()==R.id.tv_count){
        handler.removeCallbacks(task);
        Intent intent = new Intent(AdActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }else {

    }
}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);
        tv_count.setBackgroundColor(col);
        tv_count.setText(str);
        count=5;
        handler.postDelayed(task,1000);
    }
    int count = 5;
    Runnable task = new Runnable() {
        @Override
        public void run() {
            tv_count.setText("点击跳转 " + count);
            if (count > 0) {
                count--;
                handler.postDelayed(task, 1000);
            } else {
                Intent intent = new Intent(AdActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
}

