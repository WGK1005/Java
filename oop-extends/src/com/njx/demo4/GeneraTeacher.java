package com.njx.demo4;

public class GeneraTeacher extends  Teacher{

    public GeneraTeacher() {
    }

    public GeneraTeacher(String name, int age, String subject) {
        super(name, age, subject);
    }

    @Override
    public void teach() {
        System.out.println("通识课");
    }
}
