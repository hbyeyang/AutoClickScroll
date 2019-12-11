package com.lt.ks.fen.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lt.ks.fen.utils.LogUtils;

import androidx.annotation.RequiresApi;

/**
 * @author yeyang
 * @name ks
 * @class name：com.lt.ks.fen
 * @class describe
 * @time 2019-12-10 11:03
 * @change
 * @chang time
 * @class describe
 */
public class MyWebView extends WebView {

    private static String TAG = MyWebView.class.getSimpleName() + ": ";


    public MyWebView(Context context) {
        super(context);
        initSetting();
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSetting();
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initSetting();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initSetting();
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        initSetting();
    }

    @SuppressLint("JavascriptInterface")
    private void initSetting() {
        WebSettings webSettings = getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setTextZoom(100);
        // 缩放至屏幕的大小

        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAppCachePath(getContext().getFilesDir().getAbsolutePath() + "/webcache");

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) {
                    if (!url.startsWith("http:") && !url.startsWith("https:")) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });
    }

    public void goToBack(){
        this.goBack();
    }



    public static class MyWebChromeClient extends WebChromeClient {
        public MyWebChromeClient() {
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            LogUtils.d(TAG + newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            LogUtils.d(TAG + title);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            LogUtils.d(TAG + url);
            LogUtils.d(TAG + message);
            LogUtils.d(TAG + result.toString());
            return super.onJsAlert(view, url, message, result);
        }
    }
}
