package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.RecyclerviewHolder>{

    private final Context mContext;
    private final String[] mStrings;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        mStrings = context.getResources().getStringArray(R.array.titles);
    }

    // -  初始化 RecyclerviewHolder
    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // - 所有的布局加载器都可以通过  LayoutInflater.from(mContext).inflate(R.layout.fragment_2, container, false); 获得
        View item = View.inflate(mContext, R.layout.main2_item, null);
        RecyclerviewHolder holder = new RecyclerviewHolder(item);
        return holder;
    }

    // -  初始化 将 RecyclerviewHolder 和 数据绑定起来
    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.mTitleTV.setText(mStrings[position]);
    }

    // - 获取数据个数
    @Override
    public int getItemCount() {
        return  mStrings.length;
    }

    // - 管理播放的 view
    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTV, mSubTitleTV;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTV = itemView.findViewById(R.id.title);
            mSubTitleTV = itemView.findViewById(R.id.subTitle);
        }
    }
}

