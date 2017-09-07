package com.panda.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.HashMap;
import java.util.Map;

public class MyAidlService extends Service {
    public MyAidlService() {
    }

    public class AidlService extends IMyAidlInterface.Stub
    {
        @Override
        public String getValue() throws RemoteException {
            return "hahaha";
        }
    }

    public class AidlService1 extends  IMyService.Stub
    {
        @Override
        public Map getMap(String country, Product product) throws RemoteException {
            Map map=new HashMap<String,String>();
            map.put("country",country);
            map.put("name",product.getName());
            map.put("price",product.getPrice());
            return map;
        }

        @Override
        public Product getProduct() throws RemoteException {
            Product product=new Product();
            product.setName("chendi");
            product.setPrice(100);
            return product;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
//        return new AidlService();
        return new AidlService1();
    }
}
