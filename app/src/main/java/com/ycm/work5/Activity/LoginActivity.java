package com.ycm.work5.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ycm.work5.R;
import com.ycm.work5.SpTools;
import com.ycm.work5.bean.MyResponse;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tv_zh)
    EditText tv_zh;
    @BindView(R.id.tv_mm)
    EditText tv_mm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.bt_login)
    void login() {
        final String zh =tv_zh.getText().toString();
        final String mm =tv_mm.getText().toString();
//        new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                String url="http://www.baidu.com";
//                OkHttpClient httpClient = new OkHttpClient();
//                FormBody body = new FormBody.Builder()
//                        .add("uname", zh)
//                        .add("password", mm).build();
//                Request request = new Request
//                        .Builder()
//                        .url(url)
//                        .post(body)
//                        .build();
//                try {
//                    Response response = httpClient.newCall(request).execute();
//                    Log.d("Response", response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

        String url="http://10.10.16.78:8088/MobileShop/member/login2";

        OkHttpUtils
                .post()
                .url(url)
                .addParams("input", zh)
                .addParams("password", mm)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        //JSON  主线程
                        Gson gson = new Gson();
                        MyResponse response2 = gson.fromJson(response, MyResponse.class);
                        if(response2.getStatus()==0){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            SpTools.setBoolean("isLogin",true);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"登录失败："+response2.getMsg(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}

