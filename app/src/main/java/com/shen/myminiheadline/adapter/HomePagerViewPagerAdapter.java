package com.shen.myminiheadline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/6/23.
 */

public class HomePagerViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> listTabs;
    private List<Fragment> listFragments;

    public HomePagerViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomePagerViewPagerAdapter(FragmentManager fm, List<String> listTabs, List<Fragment> listFragments) {
        super(fm);
        this.listTabs = listTabs;
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTabs.get(position%listTabs.size());
    }
}
