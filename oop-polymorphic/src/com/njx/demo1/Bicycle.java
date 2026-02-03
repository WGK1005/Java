package com.njx.demo1;

public class Bicycle extends  Vehicle{

    public Bicycle()
    {
        super();
    }
    public Bicycle(String brand, int speed)
    {
        super(brand, speed);
    }

    @Override
    public void move()
        {
            System.out.println(getBrand()+"的交通工具正以"+getSpeed()+"km/h速度移动");
        }

        public void ringBell()
        {
            System.out.println("正在响铃...");
        }
}
