package com.njx.demo1;

public class Person {
    /*人：
        属性：名字，年龄，性别
        行为：行驶交通工具 (能使用所有交通工具）
     */
    private String name;
    private int age;
    private String sex;

    public Person() {
    }
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //行为
    public void drive(Vehicle vehicle)
        {
            vehicle.move();

            if(vehicle instanceof Bicycle)
            {
               Bicycle b=(Bicycle)vehicle;
               b.ringBell();
            }
            else if(vehicle instanceof Car)
            {
                Car c=(Car)vehicle;
                c.honk();
            }


        }
}
