package com.lt.ks.fen.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lt.ks.fen.R;
import com.lt.ks.fen.utils.LogUtils;
import com.lt.ks.fen.utils.WebViewUtils;
import com.lt.ks.fen.view.MyWebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author yeyang
 * @name ks
 * @class name：com.lt.ks.fen.activity
 * @class describe
 * @time 2019-12-10 15:46
 * @change
 * @chang time
 * @class describe
 */
public class AutoWebView extends AppCompatActivity {

    private static String TAG = AutoWebView.class.getSimpleName() + ": ";


    private String mUrl = "http://t.alpha.channel.45xie.com/tempview/home-qiche.html?appid=B428109E4AA4E883DB8B1877BFF3575F";
    //    private String mUrl = "https://www.hao123.com/";
//    private String mUrl = "https://www.baidu.com/?tn=sitehao123&H123Tmp=nunew11";
    private Handler mHandler;
    private WebView mWebView;
    private LinearLayout mLinearLayout;
    private int mNum;
    private TextView mTvNum;
    private boolean isFirst = false;

    public static void launch(Context context) {
        Intent intent = new Intent(context, AutoWebView.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_auto_webview);
        mWebView = new MyWebView(this);
        initView();
    }

    private void initView() {
        mLinearLayout = findViewById(R.id.ll_layout);
        mTvNum = findViewById(R.id.tv_num);
//        mWebView = findViewById(R.id.webview);
//        webviewInit(mWebView);
//        mLinearLayout.addView(mWebView);

        mWebView.loadUrl(mUrl);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int what = msg.what;
                switch (what) {
                    case 1:
                        WebViewUtils.autoClick(mWebView, 500.f, 500.f);
                        if (!isFirst) {
                            isFirst = true;
                        } else {
                            mNum++;
                            mTvNum.setText("测试广告跳转次数: " + mNum);
                        }
                        mHandler.sendEmptyMessageDelayed(2, 5000);
                        break;
                    case 2:
                        mWebView.goBack();
                        WebViewUtils.autoScroll(mWebView);
                        mHandler.sendEmptyMessage(1);
                        break;
                }
            }
        };

        mWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtils.d(TAG + event.getAction());
                LogUtils.d(TAG + event.getRawX() + "_____" + event.getRawY());
                return false;
            }
        });

        mHandler.sendEmptyMessage(1);
    }

    private void webviewInit(WebView webView) {

        WebSettings webSettings = mWebView.getSettings();

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
        webSettings.setAppCachePath(mWebView.getContext().getFilesDir().getAbsolutePath() + "/webcache");

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        mWebView.setWebViewClient(new WebViewClient() {

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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtils.d(TAG + ev.getAction());
        LogUtils.d(TAG + ev.getRawX() + "_____" + ev.getRawY());
        return super.dispatchTouchEvent(ev);
    }

}
