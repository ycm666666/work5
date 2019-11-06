package com.ycm.work5.Activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import com.ycm.work5.R;
import java.io.IOException;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.BindView;
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
        new Thread() {
            @Override
            public void run() {
                super.run();
                String url="http://www.baidu.com";
                OkHttpClient httpClient = new OkHttpClient();
                FormBody body = new FormBody.Builder()
                        .add("uname", zh)
                        .add("password", mm).build();
                Request request = new Request
                        .Builder()
                        .url(url)
                        .post(body)
                        .build();
                try {
                    Response response = httpClient.newCall(request).execute();
                    Log.d("Response", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

