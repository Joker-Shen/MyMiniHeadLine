package com.shen.myminiheadline;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DrawableUtils;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.shen.myminiheadline.fragment.FindFragment;
import com.shen.myminiheadline.fragment.HomePageFragment;
import com.shen.myminiheadline.fragment.MyselfFragment;
import com.shen.myminiheadline.fragment.WelfareFragment;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.rg) private RadioGroup rg;
    @ViewInject(R.id.homepage)private RadioButton homepage;
    @ViewInject(R.id.find)private RadioButton find;
    @ViewInject(R.id.myself)private RadioButton myself;
    @ViewInject(R.id.welfare)private RadioButton welfare;
    //@ViewInject(R.id.ll_container)private LinearLayout llContainer;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        //改变主页面下的导航按钮图片大小
        Drawable drawable = getResources().getDrawable(R.drawable.homepage);
        drawable.setBounds(0,0,70,70);
        homepage.setCompoundDrawables(null,drawable,null,null);
        drawable = getResources().getDrawable(R.drawable.find);
        drawable.setBounds(0,0,70,70);
        find.setCompoundDrawables(null,drawable,null,null);
        drawable = getResources().getDrawable(R.drawable.myself);
        drawable.setBounds(0,0,70,70);
        myself.setCompoundDrawables(null,drawable,null,null);
        drawable = getResources().getDrawable(R.drawable.welfare);
        drawable.setBounds(0,0,70,70);
        welfare.setCompoundDrawables(null,drawable,null,null);
        manager = getSupportFragmentManager();
       // manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.ll_container,new HomePageFragment());
        transaction.commit();
        //监听导航按钮，跳转Fragment
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.welfare:
                        transaction.replace(R.id.ll_container,new WelfareFragment());
                        break;
                    case R.id.homepage:
                        transaction.replace(R.id.ll_container,new HomePageFragment());
                        break;
                    case R.id.find:
                        transaction.replace(R.id.ll_container,new FindFragment());
                        break;
                    case R.id.myself:
                        transaction.replace(R.id.ll_container,new MyselfFragment());
                        break;
                }
                transaction.commit();
            }
        });

        homepage.setChecked(true);

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
