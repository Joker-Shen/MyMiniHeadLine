package com.shen.myminiheadline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.SubscribeAdapter;
import com.shen.myminiheadline.asyncTask.SubscribeAsyncTask;
import com.shen.myminiheadline.callbackInterface.SubscribeDataCallback;
import com.shen.myminiheadline.entity.SubscribeData;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SubscribeInfoActivity extends AppCompatActivity implements SubscribeDataCallback{
    @ViewInject(R.id.subscribe_pull_to_refresh_lv)private PullToRefreshListView pullToRefreshListView;
    @ViewInject(R.id.tv_title)private TextView tvTitle;
    private List<SubscribeData.DataBean.ListBean> list;
    private String url = "";
    private SubscribeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suscribe_info);
        x.view().inject(this);

        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
         url = getIntent().getStringExtra("url");
        //Log.i("SubAcUrl",url);
        list = new ArrayList<>();
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        loadData();
        adapter = new SubscribeAdapter(list,this);
        View emptyView = LayoutInflater.from(this).inflate(R.layout.net_erro_layout,null);
        pullToRefreshListView.setEmptyView(emptyView);
        pullToRefreshListView.setAdapter(adapter);

    }

    @Override
    public void callback(final SubscribeData subscribeData) {
        list.addAll(subscribeData.getData().getList());
        adapter.notifyDataSetChanged();

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                loadData();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                String nexttime = subscribeData.getData().getNexttime()+"";
                String nextsign = subscribeData.getData().getNextsign();
                url = "http://app.lerays.com/api/stream/tag/slist?nextsign="+nextsign+"&pubtime="+nexttime+"&tag_id=1";
                loadData();
                adapter.notifyDataSetChanged();
            }
        });

        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SubscribeInfoActivity.this,WebviewActivity.class);
                intent.putExtra("webUrl","http://app.lerays.com/stream/view?"+"acm=none-50-"+list.get(position-1).getStream_id()+"-"+list.get(position-1).getAck_code()+"&stream_id="+list.get(position-1).getStream_id()+"&_ack="+list.get(position-1).getAck_code());
                startActivity(intent);

            }
        });
    }


    public void loadData(){
        new SubscribeAsyncTask(this,pullToRefreshListView).execute(url);
    }
}
