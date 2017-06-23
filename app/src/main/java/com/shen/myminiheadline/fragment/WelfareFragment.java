package com.shen.myminiheadline.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.adapter.WelfareAdapter;
import com.shen.myminiheadline.asyncTask.WelfareAsyncTask;
import com.shen.myminiheadline.callbackInterface.WelfareCallback;
import com.shen.myminiheadline.entity.Welfare;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelfareFragment extends Fragment implements WelfareCallback{

    //@ViewInject(R.id.recyclerview) private RecyclerView recyclerView;
    private RecyclerView recyclerView;
    private String url = "http://image.baidu.com/channel/listjson?pn=0&rn=30&tag1=%E7%BE%8E%E5%A5%B3&tag2=%E5%85%A8%E9%83%A8&ftags=%E5%B0%8F%E6%B8%85%E6%96%B0&ie=utf8";
    private WelfareAdapter adapter;
    public WelfareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welfare,container,false);
        //x.view().inject(getActivity());??
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        new WelfareAsyncTask(this).execute(url);
        return view;

    }

    @Override
    public void callback(Welfare welfare) {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new WelfareAdapter(getContext(),welfare);
        recyclerView.setAdapter(adapter);
    }
}
