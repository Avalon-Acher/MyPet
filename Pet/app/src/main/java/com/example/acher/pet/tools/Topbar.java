package com.example.acher.pet.tools;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.acher.pet.R;

/**
 * Created by Acher on 2016/1/25.
 */
public class Topbar extends RelativeLayout {

    private ImageView imageView;
    private TextView rightText;
    private TextView textView_title;




    private Drawable left_bitmap;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private String right_title;
    private int rightTextColor;
    private float rightTextSize;

    private LayoutParams leftParams, titleParams, rightParams;
    private TopbarClickListener listener;

    public void setImageView(Bitmap imageView){
        this.imageView.setPadding(0,10,520,10);
        this.imageView.setImageBitmap(imageView);
    }
    public void setRightText(String str){
        rightText.setGravity(Gravity.CENTER);
        rightText.setPadding(0,30,30,0);
        this.rightText.setText(str);
    }
    public void setTitleText(String str){
        this.textView_title.setText(str);
    }


    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);

        left_bitmap = ta.getDrawable(R.styleable.Topbar_left);

        title = ta.getString(R.styleable.Topbar_titleText);
        titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
        titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);

        right_title = ta.getString(R.styleable.Topbar_rightText);
        rightTextColor = ta.getColor(R.styleable.Topbar_rightColor, 0);
        rightTextSize = ta.getDimension(R.styleable.Topbar_rightTextSize, 0);

        ta.recycle();

        imageView = new ImageView(context);
        rightText = new TextView(context);
        textView_title = new TextView(context);

        //imageView.setImageDrawable(left_bitmap);

        /*textView_title.setText(title);
        textView_title.setTextColor(titleTextColor);
        textView_title.setTextSize(titleTextSize);*/


       /* rightText.setText(right_title);
        rightText.setTextColor(rightTextColor);
        rightText.setTextSize(rightTextSize);*/





        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_LEFT,RelativeLayout.TRUE);
        addView(imageView, leftParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(textView_title, titleParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        addView(rightText, rightParams);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });

        rightText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });


    }


    public interface TopbarClickListener {
        public void leftClick();

        public void rightClick();
    }

    public void setTopbarClickListener(TopbarClickListener listener) {
        this.listener = listener;
    }
}
