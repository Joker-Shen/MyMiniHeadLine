package com.shen.myminiheadline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.entity.SubscribeData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shgl1hz1 on 2017/7/4.
 */

public class SubscribeAdapter extends BaseAdapter {
    private List<SubscribeData.DataBean.ListBean> list;
    private Context context;

    public SubscribeAdapter(List<SubscribeData.DataBean.ListBean> list, Context context) {
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.subscribe_pv_item_layout,null);
            holder = new ViewHolder();
            holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvVisitNum = (TextView) convertView.findViewById(R.id.tv_visit_num);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();

        }
        holder.tvVisitNum.setText(list.get(position).getVisit_num()+"");
        holder.tvTitle.setText(list.get(position).getTitle());
        Picasso.with(context).load(list.get(position).getImg_src()).into(holder.ivPic);
        return convertView;
    }

    class ViewHolder{
        private TextView tvTitle;
        private TextView tvVisitNum;
        private ImageView ivPic;
    }
}
