package com.shen.myminiheadline.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.entity.FindVp;
import com.shen.myminiheadline.entity.FindVpInfo;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * Created by shgl1hz1 on 2017/7/5.
 */

public class FindVpInfoAdapter extends BaseAdapter {
    private List<FindVpInfo.DataBean.ListBean> list;
    private Context context;

    public FindVpInfoAdapter(List<FindVpInfo.DataBean.ListBean> list, Context context) {
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
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.find_vp_info_item_layout,null);
            holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_img_src);
            holder.tvCateTitle = (TextView) convertView.findViewById(R.id.tv_cate_title);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvVisitNum = (TextView) convertView.findViewById(R.id.tv_value);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvCateTitle.setText(list.get(position).getCate_title());
        holder.tvVisitNum.setText(list.get(position).getVisit_num()+"");
        Picasso.with(context).load(list.get(position).getImg_src()).into(holder.ivPic);

        return convertView;
    }
    class ViewHolder{
        private TextView tvTitle;
        private TextView tvCateTitle;
        private TextView tvVisitNum;
        private ImageView ivPic;
    }
}
