package com.ycm.work5.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.ycm.work5.R;
import com.ycm.work5.Activity.LoginActivity;
import com.ycm.work5.SpTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends Fragment {

    @BindView(R.id.tv_my)
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        boolean isLogin = SpTools.getBoolean("isLogin", false);
        if (isLogin) {
            button.setText("退出登录");
        } else {
            button.setText("登录");
        }
    }

    @OnClick(R.id.tv_my)
    void login() {
        boolean isLongin = SpTools.getBoolean("isLogin", false);
        if (isLongin) {
            SpTools.setBoolean("isLogin", false);
            Toast.makeText(getActivity(), "退出登录成功", Toast.LENGTH_SHORT).show();
            onResume();
        } else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
