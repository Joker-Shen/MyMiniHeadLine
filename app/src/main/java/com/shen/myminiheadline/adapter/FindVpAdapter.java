package com.shen.myminiheadline.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/6/30.
 */

public class FindVpAdapter extends PagerAdapter {
    private List<ImageView> listPics;

    public FindVpAdapter(List<ImageView> listPics) {
        this.listPics = listPics;
    }

    @Override
    public int getCount() {
        return listPics.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
        container.removeView(listPics.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listPics.get(position));
        return listPics.get(position);
    }
}
