package com.njx.demo1;

public class Vehicle {
    //属性：品牌，速度
    //行为：移动move，响铃 ringbell
    private String brand;
    private int speed;

    public Vehicle() {

    }
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    //get/set

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        System.out.println(brand+"的交通工具正以"+speed+"km/h速度移动");
    }
}
