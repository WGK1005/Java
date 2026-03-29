package com.njx.Basic5;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w=scan.nextInt();
        int h=scan.nextInt();
        int d=gcd(w,h);
        if(d==1) {//没公约数，分不开
            System.out.println(0);return;
        }
        long ans=0;
        for(int i=2;i<=d;i++) {
            if(d%i==0) {//找到公约数的最小因子
                ans=((long)w/i)*(h/i);
                break;
            }
        }
        System.out.println(ans);

    }
    //求最大公约数的模板
    static int gcd(int a,int b) {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
/*
给定一个W×H的长方形，两边长度均为整数。小蓝想把它切割为很多个边长为整数的小正方形。假设切割没有任何损耗，
正方形的边长至少为2，不允许出现余料，要求所有正方形的大小相等，请问最多能切割出多少个?
输入格式
输入一行，包含两个整数W，H，用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。如果不存在满足要求的方案，输出0。
给定一个W×H的长方形，两边长度均为整数。小蓝想把它切割为很多个边长为整数的小正方形。假设切割没有任何损耗，
正方形的边长至少为2，不允许出现余料，要求所有正方形的大小相等，请问最多能切割出多少个?
输入格式
输入一行，包含两个整数W，H，用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。如果不存在满足要求的方案，输出0。
 */