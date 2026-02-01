package com.njx.demo4;

public class Test {
    public static void main(String[] args) {
        //创建对象
        BachelorStudent bs = new BachelorStudent("小王", 18, "大一");
        System.out.println(bs.getName() + bs.getAge() + bs.getGrade());
        bs.sleep();
        bs.eat();
        bs.study();
        System.out.println("---------------------------------");
        MasterStudent ms = new MasterStudent("小李", 22, "研一");
        System.out.println(ms.getName() + ms.getAge() + ms.getGrade());
        ms.sleep();
        ms.eat();
        ms.study();
    }
}
