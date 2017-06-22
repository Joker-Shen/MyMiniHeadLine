package com.shen.myminiheadline.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.entity.Welfare;
import com.shen.myminiheadline.entity.WelfareViewHolder;
import com.squareup.picasso.Picasso;

import javax.crypto.spec.IvParameterSpec;

/**
 * Created by shgl1hz1 on 2017/6/22.
 */

public class WelfareAdapter extends RecyclerView.Adapter<WelfareViewHolder> {
    private Context context;
    private Welfare welfare;
    private float picDisplayWidth;

    public WelfareAdapter(Context context, Welfare welfare) {
        this.context = context;
        this.welfare = welfare;

        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float screenDensity = dm.density;
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        picDisplayWidth = (screenWidth-30*screenDensity)/2;
        Log.i("Tag", "Screen Density is " + screenDensity + ", Width is " + screenWidth);
    }

    @Override
    public WelfareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout,null);
        WelfareViewHolder holder = new WelfareViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WelfareViewHolder holder, int position) {
        int picWidth = welfare.getData().get(position).getImage_width();
        int picHeight = welfare.getData().get(position).getImage_height();
        float picDisplayHeight = (picHeight/(float)picWidth)*picDisplayWidth;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)picDisplayWidth,(int)picDisplayHeight);
        holder.ivPic.setLayoutParams(layoutParams);
        Picasso.with(context).load(welfare.getData().get(position).getImage_url()).into(holder.ivPic);
        holder.tvText.setText(welfare.getData().get(position).getAbs());
    }

    @Override
    public int getItemCount() {
        return welfare.getData().size();
    }
}
