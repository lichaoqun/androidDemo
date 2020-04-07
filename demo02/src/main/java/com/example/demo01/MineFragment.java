package com.example.demo01;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends NavigationBarFragment {
    final String Tag = "MineFragment";

    public MineFragment(Context context) {
        super(context);
    }

    @Override
    protected View getCurrentView() {
         View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_mine, null);
        initView(view);
         return view;
    }

    private void initView(View view) {

        // - 在xml 中引用xml; 给 xml 中引用自定义的 xml的 view 赋值
        TextView nameTV = view.findViewById(R.id.user_name);
        TextView lvTV = view.findViewById(R.id.user_lv);
        nameTV.setText("村头大佬柱子哥");
        lvTV.setText("Lv.99");

        // - 使用自定义的view, 并设置按钮的事件监听
        final ProductStatus statusView =  view.findViewById(R.id.product_status_view);
        statusView.setOnClick(new ProductStatus.OnButtonClick() {
            @Override
            public void buttonDidClick(int index) {
                Log.d(Tag, "buttonDidClick: " + index + statusView.mQgtext + statusView.mQggravity);
            }
        });

    }

    @Override
    protected String getNavTitle() {
        return "我的";
    }

}
