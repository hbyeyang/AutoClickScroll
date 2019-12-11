package com.lt.ks.fen.utils;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * @author yeyang
 * @name ks
 * @class name：com.lt.ks.fen.utils
 * @class describe
 * @time 2019-12-10 17:13
 * @change
 * @chang time
 * @class describe
 */
public class WebViewUtils {

    private static String TAG = WebViewUtils.class.getSimpleName()+": ";

    public static void autoClick(WebView webView, float var1, float var2) {
        MotionEvent motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, var1, var2, 0);
        webView.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        MotionEvent var4 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, var1, var2, 0);
        webView.dispatchTouchEvent(var4);
        var4.recycle();
        Log.d(TAG, "----------------分割线------------------");
    }

    public static void autoScroll(WebView webView) {
        float var1;
        float var2;
        float var3;
        float var4;
        int var5;
        float var6;
        float var7;
        MotionEvent var8;
        int var9;
        MotionEvent var10;
        MotionEvent var11;
        if (webView.getScrollY() <= 0) {
            var1 = (float)((double)(webView.getWidth() / 4) + (double)(webView.getWidth() / 2) * Math.random());
            var2 = (float)((double)webView.getHeight() - (double)(webView.getHeight() / 2) * Math.random());
            var3 = (float)(Math.random() < 0.3D ? (double)var1 - (double)(webView.getWidth() / 8) * Math.random() : (double)var1 + (double)(webView.getWidth() / 8) * Math.random());
            var4 = (float)((double)var2 - (double)Math.abs(var3 - var1) * (4.0D + Math.random()));
            var5 = (int)(50.0D + Math.random() * 50.0D);
            var6 = (var3 - var1) / (float)var5;
            var7 = (var4 - var2) / (float)var5;
            var8 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, var1, var2, 0);
            webView.dispatchTouchEvent(var8);
            var8.recycle();

            for(var9 = 0; var9 < var5; ++var9) {
                var10 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, var1 + var6 * (float)(var9 + 1), var2 + var7 * (float)(var9 + 1), 0);
                webView.dispatchTouchEvent(var10);
                var10.recycle();
            }

            var11 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, var3, var4, 0);
            webView.dispatchTouchEvent(var11);
            var11.recycle();
        } else if (Math.random() < 0.2D) {
            var1 = (float)((double)(webView.getWidth() / 4) + (double)(webView.getWidth() / 2) * Math.random());
            var2 = (float)((double)(webView.getHeight() / 4) + (double)(webView.getHeight() / 2) * Math.random());
            var3 = (float)(Math.random() < 0.3D ? (double)var1 + (double)(webView.getWidth() / 8) * Math.random() : (double)var1 - (double)(webView.getWidth() / 8) * Math.random());
            var4 = (float)((double)var2 + (double)Math.abs(var3 - var1) * (4.0D + Math.random()));
            var5 = (int)(50.0D + Math.random() * 50.0D);
            var6 = (var3 - var1) / (float)var5;
            var7 = (var4 - var2) / (float)var5;
            var8 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, var1, var2, 0);
            webView.dispatchTouchEvent(var8);
            var8.recycle();

            for(var9 = 0; var9 < var5; ++var9) {
                var10 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, var1 + var6 * (float)(var9 + 1), var2 + var7 * (float)(var9 + 1), 0);
                webView.dispatchTouchEvent(var10);
                var10.recycle();
            }

            var11 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, var3, var4, 0);
            webView.dispatchTouchEvent(var11);
            var11.recycle();
        } else {
            var1 = (float)((double)(webView.getWidth() / 4) + (double)(webView.getWidth() / 2) * Math.random());
            var2 = (float)((double)webView.getHeight() - (double)(webView.getHeight() / 2) * Math.random());
            var3 = (float)(Math.random() < 0.3D ? (double)var1 - (double)(webView.getWidth() / 8) * Math.random() : (double)var1 + (double)(webView.getWidth() / 8) * Math.random());
            var4 = (float)((double)var2 - (double)Math.abs(var3 - var1) * (4.0D + Math.random()));
            var5 = (int)(50.0D + Math.random() * 50.0D);
            var6 = (var3 - var1) / (float)var5;
            var7 = (var4 - var2) / (float)var5;
            var8 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, var1, var2, 0);
            webView.dispatchTouchEvent(var8);
            var8.recycle();

            for(var9 = 0; var9 < var5; ++var9) {
                var10 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, var1 + var6 * (float)(var9 + 1), var2 + var7 * (float)(var9 + 1), 0);
                webView.dispatchTouchEvent(var10);
                var10.recycle();
            }

            var11 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, var3, var4, 0);
            webView.dispatchTouchEvent(var11);
            var11.recycle();
        }

    }
}
