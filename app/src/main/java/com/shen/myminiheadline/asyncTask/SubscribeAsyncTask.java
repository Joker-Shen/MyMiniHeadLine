package com.shen.myminiheadline.asyncTask;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.shen.myminiheadline.callbackInterface.SubscribeDataCallback;
import com.shen.myminiheadline.entity.SubscribeData;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shgl1hz1 on 2017/7/4.
 */

public class SubscribeAsyncTask extends AsyncTask<String,Void,SubscribeData> {

    private SubscribeDataCallback callback;
    private PullToRefreshListView pullToRefreshListView;

    public SubscribeAsyncTask(SubscribeDataCallback callback, PullToRefreshListView pullToRefreshListView) {
        this.callback = callback;
        this.pullToRefreshListView = pullToRefreshListView;
    }

    @Override
    protected SubscribeData doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(params[0]).build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String jsonStr = response.body().string();
                Gson gson = new Gson();
                SubscribeData subscribeData = gson.fromJson(jsonStr,SubscribeData.class);
                return subscribeData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(SubscribeData subscribeData) {
        super.onPostExecute(subscribeData);
        callback.callback(subscribeData);
        pullToRefreshListView.onRefreshComplete();
    }
}
