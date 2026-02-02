package com.xjn.test1;

public class Admin extends  person{

    public Admin() {
    }
    public Admin(String name, int username, int password) {
        super(name, username, password);
    }

    @Override
    public void work() {
        System.out.println("管理员工作是管理");
    }
}
