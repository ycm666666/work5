package com.ycm.work5.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.ycm.work5.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
   @BindView(R.id.tv_wb)
    WebView tv_wb;
   @BindView(R.id.tv_re)
   SwipeRefreshLayout tv_re;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }
    String url="http://www.baidu.com";

    private void initView() {
        tv_re.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tv_re.setRefreshing(false);
                tv_wb.loadUrl(url);
            }
        });


        tv_wb.getSettings().setSupportZoom(true);
        tv_wb.getSettings().setJavaScriptEnabled(true);

       tv_wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        tv_wb.loadUrl(url);
    }
    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}