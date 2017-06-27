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
 * Created by shgl1hz1 on 2017/6/27.
 */

public class HudongAdapter extends BaseAdapter {
    private List<CommonData.DataBean.ListBeanX> listBean;
    private Context context;

    public HudongAdapter(Context context, List<CommonData.DataBean.ListBeanX> listBean) {
        this.context = context;
        this.listBean = listBean;
    }

    @Override
    public int getCount() {
        return listBean.size();
    }

    @Override
    public Object getItem(int position) {
        return listBean.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int result = 0;
        if(position%5==0){
            result = 0;
        }else{
            result = 1;
        }
        return result;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if(convertView == null){
            if(position%5==0){
                holder1 = new ViewHolder1();
                convertView = LayoutInflater.from(context).inflate(R.layout.hudong_layout_one,null);
                holder1.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
                holder1.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder1.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
                convertView.setTag(holder1);
            }else{
                holder2 = new ViewHolder2();
                convertView = LayoutInflater.from(context).inflate(R.layout.hudong_layout_two,null);
                holder2.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
                holder2.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder2.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
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
            holder1.tvTitle.setText(listBean.get(position).getTitle());
            holder1.tvCount.setText(listBean.get(position).getDisplay().getValue()+"");
            Picasso.with(context).load(listBean.get(position).getImg_src()).into(holder1.ivPic);
        }else{
            holder2.tvTitle.setText(listBean.get(position).getTitle());
            holder2.tvCount.setText(listBean.get(position).getDisplay().getValue()+"");
            Picasso.with(context).load(listBean.get(position).getImg_src()).into(holder2.ivPic);
        }
        return convertView;
    }

    class ViewHolder1{
        private ImageView ivPic;
        private TextView tvTitle;
        private TextView tvCount;
    }

    class ViewHolder2{
        private ImageView ivPic;
        private TextView tvTitle;
        private TextView tvCount;
    }
}
