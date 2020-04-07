package com.example.demo01;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductStatus extends LinearLayout implements View.OnClickListener{


   public Button mLeftBtn1;
   public Button mLeftBtn2;
   public Button mLeftBtn3;
   public Button mLeftBtn4;
   public OnButtonClick mOnButtonClick;
   public Drawable mQgbackground;
   public int mQgtextColor;
   public boolean mQgfocusable;
   public float mQglayout_width;
   public float mQgfromAlpha;
   public Integer mQgframeCount;
   public String mQgtext="11";
   public float mQgpivotX;
   public int mQgorientation = 0;
   public int mQggravity;
   public Drawable mQg_background;

    public ProductStatus(Context context) {
        this(context, null);
    }

    public ProductStatus(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProductStatus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
        initAttrs(context, attrs, defStyle);
    }


    // - 设置按钮的回调的事件
    public void setOnClick(OnButtonClick callback) {
        mOnButtonClick = callback;
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyle) {
        Resources.Theme theme = context.getTheme();
        TypedArray typedArray = theme.obtainStyledAttributes(attrs, R.styleable.product_status, defStyle, 0);
        if (typedArray != null){

            /*
                reference：颜色使用 getInt：int , 图片使用 Drawable, getDrawable;
                color：getColor：int
                boolean：getBoolean：boolean
                dimension：getDimension：float
                float：getFloat：float
                integer：getInteger，getInt：Integer，int
                string：getString：String：必须是资源文件中的字符串
                fraction：getFraction：float
                enum：getInt，getInteger，getFloat，getString：int，Integer，float，String：返回的全是value的值
                flag：getInt，getFloat，getString：int，float，string：返回value值的或运算值
                混合类型：根据不能的属性而定：根据不能的属性而定：部分属性混合报错
            * */

            Drawable mQgbackground = typedArray.getDrawable(R.styleable.product_status_qgbackground);
            mQgtextColor = typedArray.getColor(R.styleable.product_status_qg_background, Color.WHITE);
            mQgfocusable = typedArray.getBoolean(R.styleable.product_status_qgfocusable, true);
            mQglayout_width = typedArray.getDimension(R.styleable.product_status_qglayout_width, 0);
            mQgfromAlpha = typedArray.getFloat(R.styleable.product_status_qgfromAlpha, 0);
            mQgframeCount = typedArray.getInteger(R.styleable.product_status_qgframesCount, 0);
            mQgtext = typedArray.getString(R.styleable.product_status_qgtext);
            mQgpivotX = typedArray.getFraction(R.styleable.product_status_qgpivotX,100,20, 10);
            mQgorientation = typedArray.getInt(R.styleable.product_status_qgorientation, 0);
            mQggravity = typedArray.getInt(R.styleable.product_status_qggravity, 0x01);
//
//            // - 复合类型, 比较复杂, 据情况而定,如果赋值的 drawable 是 selctor 类型, 则需要处理后在使用 product_status中 eg. app:qg_background="@drawable/item_title"
             mQg_background = typedArray.getDrawable(R.styleable.product_status_qg_background);

        }
        // - 回收  typedArray
        typedArray.recycle();
    }

    // - 生成 view
    private void initView(final Context context) {
        // - 查找
        LayoutInflater.from(context).inflate(R.layout.product_status,this, true);
        mLeftBtn1 = findViewById(R.id.btn_1);
        mLeftBtn2 = findViewById(R.id.btn_2);
        mLeftBtn3 = findViewById(R.id.btn_3);
        mLeftBtn4 = findViewById(R.id.btn_4);

        // - 给 button 添加点击事件
        mLeftBtn1.setOnClickListener(this);
        mLeftBtn2.setOnClickListener(this);
        mLeftBtn3.setOnClickListener(this);
        mLeftBtn4.setOnClickListener(this);

    }

    // - 按钮的点击事件
    @Override
    public void onClick(View v) {
        int index = -1;
        switch (v.getId()){
            case R.id.btn_1:{
                index = 0;
                break;
            }
            case R.id.btn_2:{
                index = 1;
                break;
            }
            case R.id.btn_3:{
                index = 2;
                break;
            }
            case R.id.btn_4:{
                index = 3;
                break;
            }
        }
        mOnButtonClick.buttonDidClick(index);

    }

    // - 回调的类
    public interface OnButtonClick{
        public void buttonDidClick(int index);
    }


}