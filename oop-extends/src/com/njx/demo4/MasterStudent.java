package com.njx.demo4;

import org.w3c.dom.ls.LSResourceResolver;

public class MasterStudent extends Student{

    public MasterStudent() {
    }

    public MasterStudent(String name, int age, String grade) {
        super(name, age, grade);
    }

    @Override
    public void study() {
        System.out.println("硕士攻读硕士学位");
    }

    @Override
    public void sleep() {
        System.out.println("豪华宿舍");
    }
}
