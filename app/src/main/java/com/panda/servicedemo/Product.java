package com.panda.servicedemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by PC on 2017/9/6.
 */

public class Product implements Parcelable {

    private String name;
    private float price;

    public static final Parcelable.Creator<Product> CREATOR=new Parcelable.Creator<Product>()
    {
        @Override
        public Product createFromParcel(Parcel parcel) {
           /* Product product=new Product();
            product.name=parcel.readString();
            product.price=parcel.readFloat();
            return product;*/
            return new Product(parcel);
        }

        @Override
        public Product[] newArray(int i) {
            return new Product[i];
        }
    };
    public Product()
    {

    }
    public Product(Parcel in)
    {
        readFromParcel(in);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel in)
    {
        name=in.readString();
        price=in.readFloat();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeFloat(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
