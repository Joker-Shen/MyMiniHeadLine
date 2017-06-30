package com.shen.myminiheadline.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.FindGvAdapter;
import com.shen.myminiheadline.adapter.FindVpAdapter;
import com.shen.myminiheadline.entity.FindGv;
import com.shen.myminiheadline.entity.FindVp;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private ViewPager viewPager;
    private List<ImageView> listPics;
    private String url = "http://app.lerays.com/api/discovery/navi";
    private String urlGv = "http://app.lerays.com/api/user/subscription/list";
    private FindVpAdapter adapter;
    private GridView gridView;
    private FindGvAdapter findGvAdapter;
    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        viewPager = (ViewPager) view.findViewById(R.id.find_vp);
        gridView = (GridView) view.findViewById(R.id.find_gv);
        listPics = new ArrayList<>();
        getViewPagerPics();
        getGridViewInfo();
        return view;
    }


    //获得三张轮播图
    public void getViewPagerPics(){
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FindVp findVp = gson.fromJson(result,FindVp.class);
                for(int i =0;i<findVp.getData().size();i++){
                    ImageView iv = new ImageView(getContext());
                    iv.setScaleType(ImageView.ScaleType.FIT_XY);
                    listPics.add(iv);
                    //Log.i("imageUrl",findVp.getData().get(i).getImg_src());
                    Picasso.with(getContext()).load(findVp.getData().get(i).getImg_src()).into(listPics.get(i));
                }
                //Log.i("listPics",listPics.size()+"");
                adapter = new FindVpAdapter(listPics);
                viewPager.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    public void getGridViewInfo(){
        RequestParams requestParams = new RequestParams(urlGv);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FindGv findGv = gson.fromJson(result,FindGv.class);
                findGvAdapter = new FindGvAdapter(findGv,getContext());
                gridView.setAdapter(findGvAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

}
