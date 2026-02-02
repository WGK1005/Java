package com.xjn.test1;

public class person {
    private String name;
    private int username;
    private int password;

    public person() {
    }

    public person(String name, int username, int password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    //行为
    public void work() {
        System.out.println("工作");
    }
}
