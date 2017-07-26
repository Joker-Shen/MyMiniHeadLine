package com.shen.myminiheadline.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.FindVpInfoAdapter;
import com.shen.myminiheadline.entity.FindVpInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    @ViewInject(R.id.tv_hot) private TextView tvHot;
    @ViewInject(R.id.tv_hudong)private TextView tvHudong;
    @ViewInject(R.id.tv_qiqu)private TextView tvQiqu;
    @ViewInject(R.id.tv_funny)private TextView tvFunny;
    @ViewInject(R.id.tv_pet)private TextView tvPet;
    @ViewInject(R.id.tv_yule)private TextView tvYule;
    @ViewInject(R.id.tv_food) private TextView tvFood;
    @ViewInject(R.id.et_text)private EditText editText;
    @ViewInject(R.id.tv_search)private TextView tvSearch;
    @ViewInject(R.id.lv)private ListView lv;

    private String urlSearch = "http://app.lerays.com/api/stream/search/es?pageno=1&w=";
    private String url = "";
    private FindVpInfoAdapter adapter;
    private List<FindVpInfo.DataBean.ListBean> list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seacrch);
        x.view().inject(this);

        lv.setVisibility(View.GONE);

        tvHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvHot.getText());
            }
        });
        tvHudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvHudong.getText());
            }
        });
        tvQiqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvQiqu.getText());
            }
        });
        tvFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvFunny.getText());
            }
        });
        tvPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvPet.getText());
            }
        });
        tvYule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvYule.getText());
            }
        });
        tvFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(tvFood.getText());
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setVisibility(View.VISIBLE);
                url = urlSearch+editText.getText().toString();
                loadData();
            }
        });

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
                adapter = new FindVpInfoAdapter(list,SearchActivity.this);
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
