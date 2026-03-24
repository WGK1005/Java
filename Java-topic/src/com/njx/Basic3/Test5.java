package com.njx.Basic3;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        int sum=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int mix= Math.abs(i-j)+Math.abs(a[i]-a[j]);
                if(mix>sum){
                    sum=mix;
                }
            }
        }
        System.out.print(sum);
    }
}
/*
题目描述
在数列 α1,α2,···,αn中，定义两个元素α; 和αj 的距离为| 一 j + |α－ αj|， 即元素下标的距离加上元素值的差的绝对值，其中|∞|表示  的绝对值。
给定一个数列，请问找出元素之间最大的元素距离。
输入描述
输入的第一行包含一个整数n。
第二行包含 n 个整数 α1,α2,···,αn，相邻的整数间用空格分隔，表示给定的数列。
其中，2≤n≤ 1000，0≤数列中的数≤104。输出描述
输出一行包含一个整数，表示答案。
 */