package com.shen.myminiheadline.entity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shen.myminiheadline.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


/**
 * Created by shgl1hz1 on 2017/6/22.
 */

public class WelfareViewHolder extends RecyclerView.ViewHolder {
    @ViewInject(R.id.iv_pic)public ImageView ivPic;
    @ViewInject(R.id.tv_text)public TextView tvText;
    public WelfareViewHolder(View itemView) {
        super(itemView);
        x.view().inject(this,itemView);
    }
}
