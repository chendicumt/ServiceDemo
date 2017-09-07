package com.panda.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 *
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("MyIntentService--->","onHandle");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService--->","onDestory");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyIntentService--->","startCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyIntentService--->","onCreate");
    }
}
