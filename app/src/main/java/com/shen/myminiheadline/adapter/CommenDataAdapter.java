package com.shen.myminiheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.entity.CommonData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/6/26.
 */

public class CommenDataAdapter extends BaseAdapter {
    private List<CommonData.DataBean.ListBean> list;
    private Context context;

    public CommenDataAdapter(List<CommonData.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        int result = 0;
        if(position%5 == 0){
            result = 0;
        }else{
            result = 1;
        }
        return result;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if(convertView == null){
            if(position %5 ==0){
                holder1 = new ViewHolder1();
                convertView = LayoutInflater.from(context).inflate(R.layout.pulltorefresh_item_layout_one,null);
                holder1.ivPic = (ImageView) convertView.findViewById(R.id.iv_img_src);
                holder1.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(holder1);
            }else{
                holder2 = new ViewHolder2();
                convertView = LayoutInflater.from(context).inflate(R.layout.pulltorefresh_item_layout_two,null);
                holder2.ivPic = (ImageView) convertView.findViewById(R.id.iv_img_src);
                holder2.tvCateTitle = (TextView) convertView.findViewById(R.id.tv_cate_title);
                holder2.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder2.tvVisitNum = (TextView) convertView.findViewById(R.id.tv_value);
                holder2.ivHasVideo = (ImageView) convertView.findViewById(R.id.iv_has_video);
                convertView.setTag(holder2);
            }
        }else{
            if(position%5==0){
                holder1 = (ViewHolder1) convertView.getTag();
            }else{
                holder2 = (ViewHolder2) convertView.getTag();
            }
        }

        if(position%5==0){
            holder1.tvTitle.setText(list.get(position).getTitle());
            Picasso.with(context).load(list.get(position).getImg_src()).into(holder1.ivPic);
        }else{
            holder2.tvTitle.setText(list.get(position).getTitle());
            holder2.tvVisitNum.setText(list.get(position).getVisit_num()+"");
            holder2.tvCateTitle.setText(list.get(position).getCate_title());
            Picasso.with(context).load(list.get(position).getImg_src()).into(holder2.ivPic);
            if(list.get(position).isHas_video() == true){
                holder2.ivHasVideo.setVisibility(View.VISIBLE);
            }else{
                holder2.ivHasVideo.setVisibility(View.GONE);
            }

            if(list.get(position).getVisit_num()>10000){
                holder2.tvVisitNum.setText(list.get(position).getVisit_num()/10000+"万+");
            }
        }


        return convertView;
    }

    private class ViewHolder1{
        private ImageView ivPic;
        private TextView tvTitle;
    }

    private class ViewHolder2{
        private TextView tvTitle;
        private TextView tvCateTitle;
        private TextView tvVisitNum;
        private ImageView ivPic;
        private ImageView ivHasVideo;
    }
}
