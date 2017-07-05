package com.shen.myminiheadline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.FindVpInfoAdapter;
import com.shen.myminiheadline.entity.FindGv;
import com.shen.myminiheadline.entity.FindVpInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class DiscoverVpActivity extends AppCompatActivity {
    @ViewInject(R.id.lv)private ListView lv;
    @ViewInject(R.id.tv_text)private TextView tvTitle;
    private String url = "";
    private String title = "";
    private FindVpInfoAdapter adapter;
    private List<FindVpInfo.DataBean.ListBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_vp);
        x.view().inject(this);
        url = getIntent().getStringExtra("lvUrl");
        title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
        loadData();

    }


    public void loadData(){
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                FindVpInfo findVpInfo = gson.fromJson(result,FindVpInfo.class);
                list = new ArrayList<FindVpInfo.DataBean.ListBean>();
                list.addAll(findVpInfo.getData().getList());
                adapter = new FindVpInfoAdapter(list,DiscoverVpActivity.this);
                lv.setAdapter(adapter);

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
