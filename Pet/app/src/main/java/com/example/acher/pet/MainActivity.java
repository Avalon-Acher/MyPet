package com.example.acher.pet;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acher.pet.tools.BitmapManage;
import com.example.acher.pet.tools.PopMore;
import com.example.acher.pet.tools.Topbar;
import com.example.acher.pet.ui.ChatFragment;
import com.example.acher.pet.ui.FriendFragment;
import com.example.acher.pet.ui.MineFragment;
import com.example.acher.pet.ui.PetFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener{

    private static Fragment currentFragment=null;
    private ViewPager viewPager;
    private List<Fragment> mFragment=new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    private TextView current_title,rightText;
    private ImageView image;

    private PopMore popMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initDatas();


    }

    //初始化数据
    private void initDatas(){

        image=(ImageView)findViewById(R.id.image);
        current_title=(TextView)findViewById(R.id.title);
        rightText=(TextView)findViewById(R.id.rightText);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.test2);
        image.setImageBitmap(BitmapManage.toRoundCorner(bitmap,600));
        current_title.setText("Pet");
        rightText.setText("更多");

        rightText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popMore==null){
                    //自定义单击事件
                    PopClickListener popListener=new PopClickListener();
                    popMore=new PopMore(MainActivity.this,popListener,280,500);

                    //监听窗口的焦点事件
                    popMore.getContentView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                            if(!hasFocus){
                                popMore.dismiss();
                            }
                        }
                    });
                }

                //设置默认读取焦点
                popMore.setFocusable(true);
                //以控件的相对位置，偏移量开始
                popMore.showAsDropDown(rightText,-220,0);
                //窗口存在，更新窗口
                popMore.update();
            }
        });


        mFragment.add(new ChatFragment());
        mFragment.add(new FriendFragment());
        mFragment.add(new PetFragment());
        mFragment.add(new MineFragment());

        viewPager=(ViewPager)findViewById(R.id.id_viewpager);

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };
        viewPager.setAdapter(mAdapter);
        viewPager.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }



    class PopClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.buyPetCenter:
                    Toast.makeText(MainActivity.this,"购宠中心",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.knowPet:
                    Toast.makeText(MainActivity.this,"宠物知识",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
