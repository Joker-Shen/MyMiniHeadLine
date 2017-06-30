package com.shen.myminiheadline.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.HudongAdapter;
import com.shen.myminiheadline.asyncTask.CommonAsyncTask;
import com.shen.myminiheadline.callbackInterface.CommonDataCallback;
import com.shen.myminiheadline.entity.CommonData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HudongFragment extends Fragment implements CommonDataCallback{

    private HudongAdapter adapter;
    private String url = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=36&cate_type=cate&pubtime=0";
    private PullToRefreshListView pullToRefreshListView;
    private List<CommonData.DataBean.ListBean> list;
    public HudongFragment() {
        // Required empty +public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hudong,container,false);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_to_refresh_lv);
        asyncTask();
        list = new ArrayList<>();
        adapter = new HudongAdapter(getContext(),list);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setAdapter(adapter);
        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.net_erro_layout,null);
        pullToRefreshListView.setEmptyView(emptyView);

        //pullToRefreshListView子项点击进入webview
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
        return view;
    }

    @Override
    public void callback(final CommonData commonData) {
        list.addAll(commonData.getData().getList());
        adapter.notifyDataSetChanged();
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                asyncTask();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                String nextsign = commonData.getData().getNextsign();
                String nexttime = commonData.getData().getNexttime()+"";
                url = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=4&cate_type=cate&pubtime="+nexttime;
                asyncTask();
            }
        });
    }
    //封装下拉刷新的异步任务
    public void asyncTask(){
        new CommonAsyncTask(this,pullToRefreshListView).execute(url);
    }
}
