package com.lt.ks.fen.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.lt.ks.fen.R;
import com.lt.ks.fen.utils.LogUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName() + ": ";
    private TextView mTvHelloWorld;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);
        LogUtils.d(TAG + SystemClock.uptimeMillis() + "");

        initView();
    }

    private void initView() {
        mTvHelloWorld = findViewById(R.id.tv_hello_world);
        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int what = msg.what;
                switch (what) {
                    case 1:
                        autoClick(mTvHelloWorld, 10.0f, 20.0f);
                        circulation();
                        break;
                    case 2:
                        AutoWebView.launch(MainActivity.this);
                        break;
                }
            }
        };


        mTvHelloWorld.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtils.d(TAG + event.getAction());
                LogUtils.d(TAG + event.getX() + "_____" + event.getY());
                return false;
            }
        });

//        mHandler.sendEmptyMessage(1);
        mHandler.sendEmptyMessageDelayed(2,5000);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtils.d(TAG + ev.getAction());
        LogUtils.d(TAG + ev.getY() + "_____" + ev.getY());
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 循环发送
     */
    private void circulation() {
        mHandler.sendEmptyMessageDelayed(1, 10000);
    }


    public static void autoClick(TextView var0, float var1, float var2) {
        MotionEvent var3 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, var1, var2, 0);
        var0.dispatchTouchEvent(var3);
        var3.recycle();
        MotionEvent var4 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, var1, var2, 0);
        var0.dispatchTouchEvent(var4);
        var4.recycle();
        Log.d(TAG, "----------------分割线------------------");
    }
}
