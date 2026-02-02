package com.xjn.test1;

public class Test {
    public static void main(String[] args) {

        // 创建学生对象并测试多态
        Student s = new Student("张三", 1001, 123456);
        Teacher t = new Teacher("李老师", 2001, 654321);
        Admin a = new Admin("管理员", 3001, 999999);
        
        StudentManger sm = new StudentManger();
        
        // 测试多态
        sm.register(s);
        sm.register(t);
        sm.register(a);
        
        // 调用各自的工作方法
        s.work();
        t.work();
        a.work();
    }
}
