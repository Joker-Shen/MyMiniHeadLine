package com.shen.myminiheadline.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.shen.myminiheadline.R;

public class WebviewActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        url = getIntent().getStringExtra("webUrl");
       // Log.i("WebViewActivityUrl",url);
        webView.loadUrl(url);
    }
}
