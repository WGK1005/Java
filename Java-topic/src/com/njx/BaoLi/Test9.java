package com.njx.BaoLi;

import java.util.*;

public class Test9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int d=sc.nextInt();
        if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
            if(d<=31){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }else if(m==4||m==6||m==9||m==11){
            if(d<=30){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }else if(m==2){
            if(d<=28){
                System.out.println("yes");
            }else{
                System.out.println("no");}
        }else if(m>12){
            System.out.println("no");
        }
    }
}
/*
小蓝正在上小学，老师要求同学们在暑假每天记日记。可是小蓝整个暑假都在玩，直到最后一天才想起要记日记。于是小蓝赶紧编了一些日记交给老师。
没想到，日记很快就被老师发现了问题，原来小蓝记完8月31日的日记，竟又记了8月32日和8 月33 日的日记。这显然是有问题的，因为根本没有8 月 32 日和 8 月 33 日。
给定一个月份和一个日期，请问2021年有没有这一天。
输入描述
输入的第一行包含一个整数m，表示月份。
第二行包含一个整数d，表示日期。其中,1 ≤m ≤ 20， 1 ≤d≤ 40。
输出描述
如果2021年有 m 月 d日，输入 yes，否则输出 no。
 */