package com.example.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public abstract class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // - 通过布局加载器, 将xml 转为 view
        ViewGroup rootView = findViewById(R.id.nav_container);
        View childView =  getCurrentView(rootView);
        rootView.addView(childView);

        // - 添加返回按钮的事件监听
        ImageButton backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // - 子类的 view
    protected abstract View getCurrentView(ViewGroup rootView);


}
