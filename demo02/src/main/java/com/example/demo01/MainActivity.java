package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private HomeFragment mHomeFragment;
    private ShopFragment mShopFragment;
    private MineFragment mMineFragment;

    private ViewGroup mHomeBtn;
    private ViewGroup mShopBtn;
    private ViewGroup mMineBtn;
    private ViewGroup mLastSelectedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // - 获取所有的按钮
        mHomeBtn = findViewById(R.id.home_btn);
        mShopBtn = findViewById(R.id.shop_btn);
        mMineBtn = findViewById(R.id.mine_btn);
        mHomeBtn.setOnClickListener(this);
        mShopBtn.setOnClickListener(this);
        mMineBtn.setOnClickListener(this);

        // - 默认选中首页
        this.onClick(mHomeBtn);
    }

    // - tabbar 按钮的事件监听
    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        // - 如果对应的 fragment 没有初始化 ,就初始化  使用代码动态添加 fragment
        NavigationBarFragment fragment = null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (viewID){
            case R.id.home_btn : {
                if (mHomeFragment == null){
                    mHomeFragment = new HomeFragment(this);
                }
                fragment = mHomeFragment;

                break;
            }
            case R.id.shop_btn : {
                if (mShopFragment == null){
                    mShopFragment = new ShopFragment(this);
                }
                fragment = mShopFragment;
                break;
            }
            case R.id.mine_btn : {
                if (mMineFragment == null){
                    mMineFragment = new MineFragment(this);
                }
                fragment = mMineFragment;
                break;
            }
        }

        if (mLastSelectedBtn!=null) {
            setViewEnableStatus(mLastSelectedBtn, true);

            // - 如果是 shopFragment, 就移除这个 fragment中嵌套的 fragment
            if (mLastSelectedBtn == mShopBtn){
                mShopFragment.removeFragment(fragmentTransaction);
            }
        }
        setViewEnableStatus((ViewGroup) v,false);
        fragmentTransaction.replace(R.id.fragment, fragment).commitAllowingStateLoss();
        mLastSelectedBtn = (ViewGroup)v;
    }

    private  void setViewEnableStatus(ViewGroup v, Boolean enable){
        for (int i = 0; i < v.getChildCount(); i++) {
            View viewChild = v.getChildAt(i);
            viewChild.setEnabled(enable);
        }
    }

}
