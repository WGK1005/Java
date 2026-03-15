package com.njx.BaoLi;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int gap=a[i]-a[i-1];
            if(gap>max){
                max=gap;
            }
        }
        System.out.println(max);
    }
}
/*
给定—个序列 α1,α2,···,an。其中α1 ≤ α2 ≤···≤ αn。相邻两个数之间的差（后一个数减前一个数）称为它们的间隙。请问序列中最大的间隙值是多少?
输入描述
输入的第一行包含一个整数n，表示序列的长度。
第二行包含 n 个正整数，为给定的序列。其中,1≤n≤ 1000,1≤α≤ 10。
输出描述
输出一个整数，表示序列中最大的间隙值。
 */