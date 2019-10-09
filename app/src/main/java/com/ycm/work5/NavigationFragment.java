package com.ycm.work5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NavigationFragment extends Fragment {
    private ImageView iv_home;
    private ImageView iv_sort;
    private ImageView iv_cart;
    private ImageView iv_my;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        iv_home = view.findViewById(R.id.iv_home);
        iv_sort = view.findViewById(R.id.iv_sort);
        iv_cart = view.findViewById(R.id.iv_cart);
        iv_my = view.findViewById(R.id.iv_my);
        resetImageResource(iv_home);
        showFragment(iv_home);
        iv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_home);
                resetImageResource(iv_home);


            }
        });
        iv_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(iv_sort);
                resetImageResource(iv_sort);

            }
        });
        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetImageResource(iv_cart);
                showFragment(iv_cart);
            }
        });
        iv_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetImageResource(iv_my);
                showFragment(iv_my);
            }
        });
    }


    private HomeFragment homeFragment;
    private SortFragment sortFragment;
    private CartFragment cartFragment;
    private MyFragment myFragment;

    private void showFragment(ImageView icon) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (cartFragment != null) {
            transaction.hide(cartFragment);
        }
        if (sortFragment != null) {
            transaction.hide(sortFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
        if (icon.getId()==R.id.iv_home){
            if (homeFragment==null){
                homeFragment=new HomeFragment();
                transaction.add(R.id.ta_tag,homeFragment);
            }else {
                transaction.show(homeFragment);
            }
        }else if (icon.getId()==R.id.iv_sort){
            if (sortFragment==null){
                sortFragment=new SortFragment();
                transaction.add(R.id.ta_tag,sortFragment);
            }else {
                transaction.show(sortFragment);
            }
        }else if (icon.getId()==R.id.iv_cart){
            if (cartFragment==null){
                cartFragment=new CartFragment();
                transaction.add(R.id.ta_tag,cartFragment);
            }else {
                transaction.show(cartFragment);
            }
        }else if (icon.getId()==R.id.iv_my){
            if (myFragment==null){
                myFragment=new MyFragment();
                transaction.add(R.id.ta_tag,myFragment);
            }else {
                transaction.show(myFragment);
            }

        }
        transaction.commit();

    }

    private void resetImageResource(View icon) {
        iv_home.setImageResource(R.mipmap.tab_item_home_normal);
        iv_cart.setImageResource(R.mipmap.tab_item_cart_normal);
        iv_sort.setImageResource(R.mipmap.tab_item_category_normal);
        iv_my.setImageResource(R.mipmap.tab_item_personal_normal);


        if (icon.getId() == R.id.iv_home) {
            iv_home.setImageResource(R.mipmap.tab_item_home_focus);
        } else if (icon.getId() == R.id.iv_sort) {
            iv_sort.setImageResource(R.mipmap.tab_item_category_focus);
        } else if (icon.getId() == R.id.iv_cart) {
            iv_cart.setImageResource(R.mipmap.tab_item_cart_focus);
        } else if (icon.getId() == R.id.iv_my) {
            iv_my.setImageResource(R.mipmap.tab_item_personal_focus);
        }

    }}

