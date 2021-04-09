package com.story.storyandroid.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public abstract class STActivity extends AppCompatActivity {

    public BaseHandler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new BaseHandler(this);
    }

    private static class BaseHandler extends Handler{
        private WeakReference<STActivity> activityWeakReference;

        private BaseHandler(STActivity activity){
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            STActivity activity = activityWeakReference.get();
            if(activity != null){

            }
        }
    }

    public abstract void handleMessage(Message message);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
