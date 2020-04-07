package com.example.demo01;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends NavigationBarFragment {

    Fragment mTopFragment;
    Fragment mBottomFragment;

    public ShopFragment(Context context) {
        super(context);
    }

    @Override
    protected View getCurrentView() {
        return  LayoutInflater.from(mContext).inflate(R.layout.fragment_shop, null);
    }

    @Override
    protected String getNavTitle() {
        return "商城";
    }

    public  void removeFragment(FragmentTransaction transaction){
        FragmentManager mgr = ((FragmentActivity)mContext).getSupportFragmentManager();
        transaction.remove(mgr.findFragmentById(R.id.ShopTopFragment)).commitNowAllowingStateLoss();
        transaction.remove(mgr.findFragmentById(R.id.ShopBottomFragment)).commitNowAllowingStateLoss();
    }
}
