package com.example.demo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.ViewHolder> {


    private Context mContext;
    ArrayList <String > mTitles;
    private Lisenter mLisenter;

    // - 两种 cell 类型
    public static enum ITEM_TYPE {
        ITEM_TYPE_0,
        ITEM_TYPE_1
    }

    // - 初始化 adapter
    public RecyclerAdapter(Context context) {
        mContext = context;
        mTitles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mTitles.add("第" + i + "条测试数据");
        }
    }

    // - 设置点击 item 的事件监听
    public void  setAdapterOnClickLintern(Lisenter lisenter){
        mLisenter = lisenter;
    }

    @NonNull
    @Override
    // - 初始化 多种 item 的 ViewHolder;
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;
        if (viewType == ITEM_TYPE.ITEM_TYPE_0.ordinal()){
            item = LayoutInflater.from(mContext).inflate(R.layout.home_item0, parent, false);
            return new Item0ViewHolder(item);
        }else{
            item = LayoutInflater.from(mContext).inflate(R.layout.home_item1, parent, false);
            return new Item1ViewHolder(item);
        }
    }

    @Override
    // - 区分两种不同的 item, 将 holdr 和 数据源的数据绑定
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if (holder instanceof Item0ViewHolder){
            Item0ViewHolder ho = (Item0ViewHolder)holder;
            ho.mTitleTV.setText(mTitles.get(position) +"item0");
            ho.mSubTitlesTV.setText(mTitles.get(position) +"item0");
            ho.mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLisenter.onItemDidClick(position, holder);
                }
            });
        }else{
            Item1ViewHolder ho = (Item1ViewHolder)holder;
            ho.mTitleTV1.setText(mTitles.get(position) + "item1");
            ho.mSubTitlesTV1.setText(mTitles.get(position) +"item1");
            ho.mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mLisenter.onItemDidClick(position, holder);
                }
            });
        }
    }

    // - 可以根据不同的类型返回不同的 type
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0)
            return ITEM_TYPE.ITEM_TYPE_0.ordinal();
        return ITEM_TYPE.ITEM_TYPE_1.ordinal();
    }

    @Override
    // - 数据个数
    public int getItemCount() {
        return mTitles.size();
    }


    // - ViewHolder 类
    public class ViewHolder extends  RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    // -  item0 类
    public class Item0ViewHolder extends  ViewHolder{

        TextView mTitleTV, mSubTitlesTV;
        View mItemView;
        public Item0ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTV = itemView.findViewById(R.id.title_home);
            mSubTitlesTV = itemView.findViewById(R.id.subTitle_home);
            mItemView = itemView;
        }
    }

    // -  item1 类
    public class Item1ViewHolder extends  ViewHolder{

        TextView mTitleTV1, mSubTitlesTV1;
        View mItemView;
        public Item1ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTV1 = itemView.findViewById(R.id.title_home1);
            mSubTitlesTV1 = itemView.findViewById(R.id.subTitle_home1);
            mItemView = itemView;
        }
    }

    // - 点击 item 的回调
    public interface Lisenter {
        public void onItemDidClick(int position, RecyclerView.ViewHolder holder);
    }
}
