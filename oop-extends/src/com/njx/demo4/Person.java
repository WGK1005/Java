package com.njx.demo4;

public class Person {
    private String name;
    private int age;

    //构造方法
    //空参构造


    public Person() {
    }
    //全参数

    public Person(String name,int  age) {
        this.name = name;
        this.age = age;
    }
    //get set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}
