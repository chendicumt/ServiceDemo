// IMyService.aidl
package com.panda.servicedemo;
import com.panda.servicedemo.Product;
// Declare any non-default types here with import statements

interface IMyService {
   Map getMap(in String country,in Product product);
   Product getProduct();
}
