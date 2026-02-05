package com.njx.topic1;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        //红包问题
        //给你两个整数M和N，M表示红包的总额，N表示红包的个数
        //现在又N个人来抽红包，每个人都是随机的，打印每个人领的红包金额

        //注1：每个人最少1分钱
        //注2：每个人领完红包之后，至少预留1＊N分钱
        //注3：最后一个人是拿剩余的总额
        //定义变量表示总额
        int money=20000;//分
        //定义红包个数
        int n=5;
        //判断红包金额是否足够，即没人最少1分钱
        if(money<n)
        {
            System.out.println("红包金额不够");
        }else {
            //循环抽取红包
            Random r=new Random();
            for (int i = 1; i <= n-1; i++) {
                //利用Random随机抽取    1 2 3 4 表示第几人抽取
                //                     4 3 2 1 表示预留的钱
                //money-（n-i）：至少给后面的人预留一分钱
                //+1：至少给最后一个人预留一分钱
                int Mymoney=r.nextInt(money-(n-i))+1;

                //总额减去当前红包金额
                money-=Mymoney;

                System.out.println("第"+(i+1)+"个人抢到"+Mymoney+"分钱");

            }
            //最后一人抢到的钱
            System.out.println("最后一个人抢到"+money+"分钱");
        }
    }
}
