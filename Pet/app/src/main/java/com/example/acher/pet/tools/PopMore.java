package com.example.acher.pet.tools;

import android.app.Activity;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.acher.pet.R;

/**
 * Created by Acher on 2016/1/25.
 */
public class PopMore extends PopupWindow {
    private View mainView;
    //各项功能
    private LinearLayout buyPetCenter,knowPet;

    public PopMore(Activity activity, View.OnClickListener listener, int paramsInt1, int paramsInt2)
    {
        super(activity);
        //窗口布局
        mainView= LayoutInflater.from(activity).inflate(R.layout.popmore,null);
        //购宠中心布局
        buyPetCenter=(LinearLayout)mainView.findViewById(R.id.buyPetCenter);
        //宠物知识布局
        knowPet=(LinearLayout)mainView.findViewById(R.id.knowPet);

        //设置每个布局的监听器
        if(listener!=null)
        {
            buyPetCenter.setOnClickListener(listener);
            knowPet.setOnClickListener(listener);
        }

        setContentView(mainView);
        //设置宽度
        setWidth(paramsInt1);
        //设置高度
        setHeight(paramsInt2);
        //设置显示和隐藏动画
        setAnimationStyle(R.style.AnimTools);
        //设置背景透明
        setBackgroundDrawable(new ColorDrawable(0));
    }
}
