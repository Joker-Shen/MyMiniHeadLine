package com.shen.myminiheadline.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.CommenDataAdapter;
import com.shen.myminiheadline.asyncTask.CommonAsyncTask;
import com.shen.myminiheadline.callbackInterface.CommonDataCallback;
import com.shen.myminiheadline.entity.CommonData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment implements CommonDataCallback {
    private String url0 = "http://app.lerays.com/api/stream/rec/list?cate_sign=null&pubtime=0";
    private String url1 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=31&cate_type=cate&pubtime=0";
    private String url2 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=4&cate_type=cate&pubtime=0";
    private String url3 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=34&cate_type=cate&pubtime=0";
    private String url4 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=3&cate_type=cate&pubtime=0";
    private String url5 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=35&cate_type=cate&pubtime=0";
    private String url6 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=36&cate_type=cate&pubtime=0";
    private String url7 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=15&cate_type=cate&pubtime=0";
    private String url8 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=16&cate_type=cate&pubtime=0";
    private String url9 = "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=19&cate_type=cate&pubtime=0";
    private String url10= "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=8&cate_type=cate&pubtime=0";
    private String url11= "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=18&cate_type=cate&pubtime=0";
    private String url12= "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=32&cate_type=cate&pubtime=0";
    private String url13= "http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=5&cate_type=cate&pubtime=0";

    private CommenDataAdapter adapter;
    private Bundle bundle;

    private PullToRefreshListView pullToRefreshListView;
    private int key;
    private int id;
    private List<CommonData.DataBean.ListBean> list;

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        //lvInfos = (ListView) view.findViewById(R.id.lvInfos);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_to_refresh_lv);

        bundle = getArguments();
        key = bundle.getInt("key");
        Log.i("++++++++++++++++++", key + "");
        getAsyncTask();
        list = new ArrayList();
        adapter = new CommenDataAdapter(list, getContext());
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        //lvInfos.setAdapter(adapter);
        pullToRefreshListView.setAdapter(adapter);
        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.net_erro_layout, null);
        pullToRefreshListView.setEmptyView(emptyView);
        return view;
    }


    public void getAsyncTask() {
        switch (key) {
            case 0:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url0);
                break;
            case 1:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url1);
                break;
            case 2:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url2);
                break;
            case 3:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url3);
                break;
            case 4:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url4);
                break;
            case 5:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url5);
                break;
            case 6:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url6);
                break;
            case 7:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url7);
                break;
            case 8:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url8);
                break;
            case 9:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url9);
                break;
            case 10:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url10);
                break;
            case 11:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url11);
                break;
            case 12:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url12);
                break;
            case 13:
                new CommonAsyncTask(this, pullToRefreshListView).execute(url13);
                break;

        }
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

                // Do work to refresh the list here.

                getAsyncTask();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //http://app.lerays.com/api/stream/rec/list?cate_sign=null&pubtime=0
                //http://app.lerays.com/api/stream/list?cate_sign=null&cate_list=4&cate_type=cate&pubtime=0
                //getTabID();

                String nextsign = commonData.getData().getNextsign();
                String nexttime = commonData.getData().getNexttime()+"";
                if(key == 0){
                    url0 = "http://app.lerays.com/api/stream/rec/list?cate_sign="+nextsign+"&pubtime="+nexttime;
                }else{
                    url1 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=31&cate_type=cate&pubtime="+nexttime;
                    url2 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=4&cate_type=cate&pubtime="+nexttime;
                    url3 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=34&cate_type=cate&pubtime="+nexttime;
                    url4 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=3&cate_type=cate&pubtime="+nexttime;
                    url5 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=35&cate_type=cate&pubtime="+nexttime;
                    url6 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=36&cate_type=cate&pubtime="+nexttime;
                    url7 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=15&cate_type=cate&pubtime="+nexttime;
                    url8 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=16&cate_type=cate&pubtime="+nexttime;
                    url9 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=19&cate_type=cate&pubtime="+nexttime;
                    url10 = "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=8&cate_type=cate&pubtime="+nexttime;
                    url11= "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=18&cate_type=cate&pubtime="+nexttime;
                    url12= "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=32&cate_type=cate&pubtime="+nexttime;
                    url13= "http://app.lerays.com/api/stream/list?cate_sign="+nextsign+"&cate_list=5&cate_type=cate&pubtime="+nexttime;
                }
                getAsyncTask();
            }
        });

//        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getContext(), WebViewActivity.class);
//                intent.putExtra("webUrl",list.get(i-1).getQuery_string());
//                startActivity(intent);
//            }
//        });


    }


}