package com.shen.myminiheadline.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.entity.FindGv;
import com.squareup.picasso.Picasso;

/**
 * Created by shgl1hz1 on 2017/6/30.
 */

public class FindGvAdapter extends BaseAdapter {
    private FindGv findGv;
    private Context context;

    public FindGvAdapter(FindGv findGv, Context context) {
        this.findGv = findGv;
        this.context = context;
    }

    @Override
    public int getCount() {
        return findGv.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return findGv.getData().get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.find_gv_item_layout,null);
            holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
            holder.tvCount = (TextView) convertView.findViewById(R.id.tv_count);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(findGv.getData().get(position).getTitle());
        holder.tvCount.setText(findGv.getData().get(position).getSubscribers()+"人已订阅");
        Log.i("imgSrc",findGv.getData().get(position).getImg_src().toString());
        Picasso.with(context).load(findGv.getData().get(position).getImg_src()).into(holder.ivPic);

        return convertView;
    }

    class ViewHolder{
        private TextView tvTitle;
        private TextView tvCount;
        private ImageView ivPic;
    }
}
