package com.xjn.test1;

public class StudentManger {

    //定义一个方法表示注册用户
    //参数person，可传person本身，也可传子类

    public void register(person person) {
       //姓名为小王的同学注册成功，账号xiaowang，密码123456
        System.out.println("姓名为" + person.getName() + "的用户注册成功，账号" + person.getUsername() + "，密码" + person.getPassword());
    }


}

