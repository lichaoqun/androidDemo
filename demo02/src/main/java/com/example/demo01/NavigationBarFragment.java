package com.example.demo01;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class NavigationBarFragment extends Fragment {

    Context mContext;

    public NavigationBarFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // - 布局加载器 将 xml 转为 viewGroup
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_navigation_bar, container, false);

        // - 获取下边的视图,并加入到 viewGroup 中
        View childView = getCurrentView();
        rootView.addView(childView);

        // - 设置导航标题
        TextView titleTV = rootView.findViewById(R.id.nav_title);
        titleTV.setText(this.getNavTitle());

        return rootView;
    }

    // - 获取导航下边的视图
    protected abstract View getCurrentView();

    // - 获取 view 的标题
    protected abstract String getNavTitle();
}
