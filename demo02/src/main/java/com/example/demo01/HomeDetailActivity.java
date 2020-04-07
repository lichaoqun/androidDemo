package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeDetailActivity extends NavigationActivity {

    @Override
    protected View getCurrentView(ViewGroup rootView) {
        View childView = LayoutInflater.from(this).inflate(R.layout.activity_home_detail, rootView, false);
        return childView;
    }
}
