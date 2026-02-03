package com.njx.demo1;

public class Car extends  Vehicle{

    public Car()
    {
        super();
    }
    public Car(String brand, int speed)
    {
        super(brand, speed);
    }

    @Override
    public void move()
        {
            System.out.println(getBrand()+"的交通工具正以"+getSpeed()+"km/h速度移动");
        }

        public void honk()
        {
            System.out.println("正在鸣笛...");
        }

}
