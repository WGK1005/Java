package com.njx.demo3;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== 测试智能设备功能 ===");
        phone p=new phone();
        p.name="xiaomi";
        p.price=4999;

        double payment=p.payment();
        System.out.println(payment);
    }

}
