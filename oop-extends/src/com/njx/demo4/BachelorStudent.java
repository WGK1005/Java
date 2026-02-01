package com.njx.demo4;

public class BachelorStudent extends  Student{
    //私有化成员变量 不写 无独有

    //空参
    //全参（间接父类+直接父类+自己）

    public BachelorStudent() {
    }

    public BachelorStudent(String name, int age, String grade) {
        super(name, age, grade);
    }
    //get set（没有）
    //重写方法

    @Override
    public void study() {
        System.out.println("本科生攻读本科学位");
    }
}
