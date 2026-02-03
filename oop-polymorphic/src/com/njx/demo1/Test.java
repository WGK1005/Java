package com.njx.demo1;

import javax.naming.Name;

public class Test {
    public static void main(String[] args) {
       /*
       自行车：
        属性：品牌，行驶速度
        行为：移动move，响铃ringBell（)
        汽车：
        属性：品牌，行驶速度
        行为：移动move，鸣笛honk（)
        人：
        属性：名字，年龄，性别
        行为：行驶交通工具 (能使用所有交通工具）
                测试类中创建Person的对象，让这个人使用任意一款交通工具
        */
        Person P=new Person("张三",18,"男");
        System.out.println(P.getName()+ P.getAge()+ P.getSex());

        //创建自行车
        Bicycle bicycle=new Bicycle("凤凰",10);
        System.out.println(bicycle.getBrand()+ bicycle.getSpeed());

        //创建汽车
        Car car=new Car("保时捷",80);
        System.out.println(car.getBrand()+ car.getSpeed());
    }
}
