package com.xjn.test1;

public class Student extends  person{

    public Student() {
    }

    public Student(String name, int username, int password) {
        super(name, username, password);
    }

    @Override
    public void work() {
        System.out.println("学生工作是学习");
    }
}