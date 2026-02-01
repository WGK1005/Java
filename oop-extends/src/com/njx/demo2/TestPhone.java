package com.njx.demo2;

public class TestPhone {
    public static void main(String[] args) {
        System.out.println("=== 测试手机类继承关系 ===");
        
        // 测试第一代手机
        System.out.println("1. 测试第一代手机:");
        FirstPhone fp = new FirstPhone();
        fp.call();
        
        System.out.println("---------------------------------");
        
        // 测试第二代手机
        System.out.println("2. 测试第二代手机:");
        SecondPhone sp = new SecondPhone();
        sp.call();      // 继承自父类的方法
        sp.sendmessage(); // 自己定义的方法
        
        System.out.println("---------------------------------");
        
        // 测试第三代手机
        System.out.println("3. 测试第三代手机:");
        ThirdPhone tp = new ThirdPhone();
        tp.call();      // 重写父类的方法
        tp.sendmessage(); // 继承自父类的方法
        
        System.out.println("---------------------------------");
        
        // 演示多态性
        System.out.println("4. 测试多态性:");
        FirstPhone poly1 = new FirstPhone();
        FirstPhone poly2 = new SecondPhone();  // 父类引用指向子类对象
        FirstPhone poly3 = new ThirdPhone();   // 父类引用指向子类对象
        
        System.out.println("普通手机:");
        poly1.call();
        
        System.out.println("第二代手机（作为第一代手机使用）:");
        poly2.call();  // 实际执行的是SecondPhone继承的方法
        
        System.out.println("第三代手机（作为第一代手机使用）:");
        poly3.call();  // 实际执行的是ThirdPhone重写后的方法
    }
}