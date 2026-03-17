package com.njx.DP;

import java.util.*;
//这个暴力很有意思，按照注释的方法就会超时，按照现在就不会
public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long result = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
           // long sum = 0;
            sum = 0;
            for (int j = i; j < n; j++) {
                sum ^= a[j];
                result+=sum;
            }
        }
        System.out.println(result);
    }
}
/*
给定一个数组A，分别求其每个子段的异或和，并求出它们的和。或者说，对于每组满足 1 ≤ L≤ R≤ n 的L,R，求出数组中第L至第 R 个元素的异或和。然后输出每组 L，R 得到的结果加起来的值。
输入格式
输入的第一行包含一个整数n。
第二行包含个整数A，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */