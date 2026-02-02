package com.xjn.test1;

public class Teacher extends  person{
    public Teacher() {
    }

    public Teacher(String name, int username, int password) {
        super(name, username, password);
    }

    @Override
    public void work() {
        System.out.println("老师工作是教书");
    }
}
