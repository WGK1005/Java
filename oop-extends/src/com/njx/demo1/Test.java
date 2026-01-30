package com.njx.demo1;

public class Test {
    public static void main(String[] args) {
        //创建布偶猫对象
        Ragdoll rd = new Ragdoll();
        rd.eat();
        rd.drink();
        rd.catchMouse();

        System.out.println("---------------------------------");
        //创建哈士奇对象
        Husky hs = new Husky();
        hs.eat();
        hs.drink();
        hs.lookhome();
        hs.breakHome();
    }
}
