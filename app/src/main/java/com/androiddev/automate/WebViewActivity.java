package com.androiddev.automate;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Bundle extras = getIntent().getExtras();
        String link = extras.getString("link");

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        webView.setWebViewClient(new WebViewClient({
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                mWebView.loadUrl("file:///android_asset/myerrorpage.html");
//            }
//        }));
//        webView.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//
//            }
//        });
//        web
//        View.loadUrl(link);
        webView.loadUrl(link);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}