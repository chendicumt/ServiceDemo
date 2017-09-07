package com.panda.servicedemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private  ExecuteBinder executeBinder=new ExecuteBinder();
    public MyService() {

    }
//Activity与service交互
    class ExecuteBinder extends Binder{
        public void start()
        {
            Log.d("MyService--->","startExecute");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return executeBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService--->", "onCreate()");

//        前台服务
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this).setContentTitle("11").
                setContentText("aa").setWhen(System.currentTimeMillis()).
                setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pendingIntent).build();

        startForeground(1,notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService--->","onDestory()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService--->","onStart()");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MyService--->","thread");
//                处理具体逻辑
//                停止服务
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);

    }
}
