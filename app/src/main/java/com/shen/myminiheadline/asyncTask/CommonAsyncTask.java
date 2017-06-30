package com.shen.myminiheadline.asyncTask;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.callbackInterface.CommonDataCallback;
import com.shen.myminiheadline.entity.CommonData;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shgl1hz1 on 2017/6/29.
 */

public class CommonAsyncTask extends AsyncTask<String,Void,CommonData> {
    private CommonDataCallback commonDataCallback;
    private PullToRefreshListView pullToRefreshListView;

    public CommonAsyncTask(CommonDataCallback commonDataCallback, PullToRefreshListView pullToRefreshListView) {
        this.commonDataCallback = commonDataCallback;
        this.pullToRefreshListView = pullToRefreshListView;
    }

    @Override
    protected CommonData doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(params[0]).build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String jsonStr = response.body().string();
                Gson gson = new Gson();
                CommonData commonData = gson.fromJson(jsonStr,CommonData.class);
                return commonData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(CommonData commonData) {
        super.onPostExecute(commonData);
        commonDataCallback.callback(commonData);
        pullToRefreshListView.onRefreshComplete();
    }
}
