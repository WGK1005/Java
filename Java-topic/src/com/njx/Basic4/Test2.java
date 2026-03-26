package com.njx.Basic4;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long L=sc.nextLong();
        int count=0;
        while(L>=1){
            L/=2;
            count++;
        }
        System.out.println(count);
    }
}
/*
小蓝有一根长度为L 的绳子，每对折一次，长度变为原来的一半，请问对折多少次后长度不超过1。
例如，当L = 6 时，对折一次长度为 3，对折两次长度为
1.5，对折3次长度为0.75，所以3次后长度不超过 1。
输入格式
输入一行包含一个整数。
输出格式
输出一行包含一个整数，表示答案。
 */