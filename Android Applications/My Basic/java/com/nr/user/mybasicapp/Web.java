package com.nr.user.mybasicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    private WebView webviewer;
    private static String TAG = "TAG";
    private static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        url = getIntent().getStringExtra("url");


        webviewer = (WebView)findViewById(R.id.web);
        webviewer.setWebViewClient(new WebViewClient()
        {
            @SuppressWarnings("deprecation")

            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {
                view.loadUrl(url);
                Log.i(TAG, "shouldOverrideUrlLoading: "+url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                webviewer.setVisibility(View.GONE);
            }
        });
        webviewer.getSettings().setLoadsImagesAutomatically(true);
        webviewer.getSettings().setJavaScriptEnabled(true);
        webviewer.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webviewer.loadUrl(url);
    }
}
