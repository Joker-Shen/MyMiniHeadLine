package com.shen.myminiheadline.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.CommenDataAdapter;
import com.shen.myminiheadline.adapter.HudongAdapter;
import com.shen.myminiheadline.entity.CommonData;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment {
    private String url ="";
    private PullToRefreshListView pullToRefreshListView;
    private List<CommonData.DataBean.ListBeanX> listBean;
    private CommenDataAdapter adapter;
    private String nextSign = "";
    private String nextTimer = "";
    private Bundle bundle;
    private HudongAdapter hudongAdapter ;

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_common,container,false);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_to_refresh_lv);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        bundle = new Bundle();
        bundle = getArguments();
        Log.i("CommenFrebundle",bundle.toString());
        url = bundle.getString("url");
        Log.i("url",url);
        listBean = new ArrayList<>();
        loadData();
       // Log.i("listBeanSize+++",listBean.size()+"");


        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
        return view;
    }

    public void loadData(){
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                CommonData commonData = gson.fromJson(result,CommonData.class);
                listBean = commonData.getData().getList();
                if(bundle.getString("id").equals("33")){
                    hudongAdapter = new HudongAdapter(getContext(),listBean);
                    pullToRefreshListView.setAdapter(hudongAdapter);
                }else{
                    adapter = new CommenDataAdapter(listBean,getContext());
                    pullToRefreshListView.setAdapter(adapter);
                }

                pullToRefreshListView.onRefreshComplete();
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
