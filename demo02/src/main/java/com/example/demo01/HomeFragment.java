package com.example.demo01;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static androidx.recyclerview.widget.DividerItemDecoration.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends NavigationBarFragment {

    private static String Tag = "HomeFragment";
    private RecyclerView mRecyclerView;

    public HomeFragment(Context context) {
        super(context);
    }

    @Override
    protected View getCurrentView() {
        // - 设置顶部的导航栏
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_home, null);

        // - 设置 recyclerView
        this.setRecyclerView(view);
        return view;
    }

    // - 设置 recyclerView
    private void setRecyclerView(View view) {

        // - 查找 recyclerView
        mRecyclerView = view.findViewById(R.id.recyclerView);

        // - 设置布局方法
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        // - 设置适配器
        RecyclerAdapter adapter = new RecyclerAdapter(mContext);

        // - 设置item 选中的事件监听
        adapter.setAdapterOnClickLintern(new RecyclerAdapter.Lisenter() {
            @Override
            public void onItemDidClick(int position, RecyclerView.ViewHolder holder) {
                Intent intent = new Intent(mContext, HomeDetailActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);

        // - 添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, VERTICAL));
    }

    @Override
    protected String getNavTitle() {
        return "首页";
    }

}
