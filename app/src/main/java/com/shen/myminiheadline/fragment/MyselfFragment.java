package com.shen.myminiheadline.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shen.myminiheadline.R;
import com.shen.myminiheadline.activity.BaiduMapActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyselfFragment extends Fragment {

    private TextView tvGotoBaiduMap;
    public MyselfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_myself,container,false);
        tvGotoBaiduMap = (TextView) view.findViewById(R.id.tv_goto_baiduMap);
        tvGotoBaiduMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BaiduMapActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }



}
