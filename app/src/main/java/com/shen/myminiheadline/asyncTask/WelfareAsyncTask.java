package com.shen.myminiheadline.asyncTask;

import android.os.AsyncTask;
import android.transition.CircularPropagation;

import com.google.gson.Gson;
import com.shen.myminiheadline.callbackInterface.WelfareCallback;
import com.shen.myminiheadline.entity.Welfare;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shgl1hz1 on 2017/6/22.
 */

public class WelfareAsyncTask extends AsyncTask<String,Void,Welfare> {

    private WelfareCallback welfareCallback;

    public WelfareAsyncTask(WelfareCallback welfareCallback) {
        this.welfareCallback = welfareCallback;
    }

    @Override
    protected Welfare doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(params[0]).build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String jsonStr = response.body().string();
                Gson gson = new Gson();
                Welfare welfare = gson.fromJson(jsonStr,Welfare.class);
                return welfare;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Welfare welfare) {
        super.onPostExecute(welfare);
        welfareCallback.callback(welfare);
    }
}
