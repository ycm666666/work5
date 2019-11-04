package com.ycm.work5.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.ycm.work5.R;
import com.ycm.work5.Activity.LoginActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class MyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick(R.id.tv_my)
    void login(){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }


}
