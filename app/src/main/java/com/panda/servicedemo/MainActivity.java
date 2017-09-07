package com.panda.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyService.ExecuteBinder executeBinder;
//    private IMyAidlInterface aidlService;
    private MyAidlService.AidlService aidlService;
    private MyAidlService.AidlService1 aidlService1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startBtn(View view)
    {
        Intent intent1=new Intent(this,MyService.class);
        startService(intent1);
        Intent intent2=new Intent(this,MyIntentService.class);
        startService(intent2);
    }
    public void stopBtn(View view)
    {
        Intent intent=new Intent(this,MyService.class);
        stopService(intent);
    }

    public void bindBtn(View view)
    {
        Intent intent=new Intent(this,MyService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    public void unbindBtn(View view)
    {
        unbindService(connection);
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            executeBinder=(MyService.ExecuteBinder)iBinder;
            executeBinder.start();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    private  ServiceConnection connection1=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            aidlService=IMyAidlInterface.Stub.asInterface(iBinder);
//            aidlService=(MyAidlService.AidlService)iBinder;//普通数据
            aidlService1=(MyAidlService.AidlService1)iBinder;//parcelable
            try {
                String s="";
//              s=aidlService.getValue();
                s=aidlService1.getProduct().getName()+aidlService1.getProduct().getPrice()+
                        aidlService1.getMap("country",aidlService1.getProduct());
                Log.d("MyAidlService--->", s);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void aidlBindBtn(View view)
    {
        Intent intent=new Intent("com.panda.servicedemo.IMyAidlInterface");
        intent.setPackage("com.panda.servicedemo");
        bindService(intent,connection1, Context.BIND_AUTO_CREATE);
    }


    public void serializable()
    {
        Products products=new Products();
        products.setName("apple");
        products.setPrice(10);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("o",products);
        startActivity(intent);
    }
    public void reverseSerializable()
    {
        Products products=(Products)getIntent().getSerializableExtra("o");
        String name=products.getName();
        float price=products.getPrice();
    }

    public void parcel()
    {
        Product product=new Product();
        product.setName("apple");
        product.setPrice(10);
        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("o",product);
        startActivity(intent);
    }
    public void reverseparcelable()
    {
        Product product=(Product)getIntent().getParcelableExtra("o");
        String name=product.getName();
        float price=product.getPrice();
    }


}
