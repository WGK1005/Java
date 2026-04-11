package com.njx.Basic9;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        long a = scan.nextLong();
        long b = scan.nextLong();
        long n = scan.nextLong();

        long weeksum = 5*a+2*b;                       //做题满一周的总做题数
        long weeks = n/weeksum;                       //做满一周题的周数
        long remainder = n-weeks*weeksum;             //剩余题数
        long day;

        if(remainder > 5*a){                            //若剩余题数大于5a，则达到做题数目的最后一天是周末
            if(remainder-5*a>b){                        //周日
                day = 7*(weeks+1);
            }else {                                     //周六
                day = 7*weeks+6;
            }
        }else {                                         //非周末情况
            if (remainder % a != 0){
                day = 7*weeks + 1 + remainder/a;
            }else {
                day = 7*weeks + remainder/a;
            }
        }

        System.out.println(day);
        scan.close();
    }
}
/*
小明决定从下周一开始努力刷题准备蓝桥杯竞赛。他计划周一至周五每天做α道题目，周六和周日每天做b道题目。请你帮小明计算，按照计划他将在 第几天实现做题数大于等于n题?
输入格式
输入一行包含三个整数a，b和n
输出格式
输出一个整数代表天数。
 */