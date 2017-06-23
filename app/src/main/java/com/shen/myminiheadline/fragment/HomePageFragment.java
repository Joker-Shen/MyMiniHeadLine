package com.shen.myminiheadline.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.HomePagerViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayout tabPic;
    private List<String> listTabs;
    private HomePagerViewPagerAdapter adapter;
    private List<Fragment> listFragments;
    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page,container,false);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabPic = (TabLayout) view.findViewById(R.id.tab_pic);
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
        listFragments = new ArrayList<>();
       // listFragments.add(new CommonFragment());
        listTabs= new ArrayList<>();
        listTabs.add("热门");
        listTabs.add("互动");
        listTabs.add("奇趣");
        listTabs.add("娱乐");
        listTabs.add("萌宠");
        listTabs.add("爆笑");
        listTabs.add("生活");
        listTabs.add("视频");
        listTabs.add("情感");
        listTabs.add("美食");
        listTabs.add("创意");
        listTabs.add("体育");
        listTabs.add("健康");
        listTabs.add("资讯");
        listTabs.add("美女");
        for(int i=0;i<listTabs.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(listTabs.get(i)));
            tabPic.addTab(tabPic.newTab().setText(listTabs.get(i)));
            CommonFragment commonFragment = new CommonFragment();
            listFragments.add(commonFragment);
        }
        tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
        tabPic.setTabMode(tabLayout.MODE_SCROLLABLE);
        tabPic.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setIcon(R.mipmap.top_tab_bottom);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setIcon(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        adapter = new HomePagerViewPagerAdapter(getChildFragmentManager(),listTabs,listFragments);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabPic.setupWithViewPager(viewPager);
        return view;
    }

}
