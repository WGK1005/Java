package com.njx.demo4;

public class MajorTeacher extends  Teacher{

    public MajorTeacher() {
    }

    public MajorTeacher(String name, int age, String subject) {
        super(name, age, subject);
    }

    @Override
    public void teach() {
        System.out.println("老师正在讲专业课");
    }
}