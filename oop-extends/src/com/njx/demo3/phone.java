package com.njx.demo3;

public class phone extends SmartDevice{
    @Override
    /*public double payment() {
        if(price >=0 && price<1000){
          price = price*1.0;
        }else if(price >= 1000 && price< 5000){
            price = price*0.9;
        } else if(price >= 5000 && price< 10000){return price * 0.8;
        } else if(price >= 10000){
            price = price * 0.7;
        } else {
            price = 0;
        }*/
    //直接调用父类计算后的值
    public double payment() {
        double payment = super.payment();
        payment = payment*0.9;
        return payment;
    }
}
