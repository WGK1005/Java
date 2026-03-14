package com.njx.TanXin;

import java.util.*;
//通过率75，国赛题，还是要多想一步。目前无法优化，等有机会再说
public class Test16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        long ans=0;
        long pre=a[0];

        for(int i=1;i<n;i++){
            long cur=a[i];
            while(cur<pre){
                cur*=2;
                ans++;
            }
            pre=cur;
        }
        System.out.println(ans);
    }
}
/*
给定n 个正整数 A1,A2,···，An，每次操作可以选择任意一个数翻倍。请输出让序列单调不下降，也就是每个数都不小于上一个数，最少需要操作多少次？
输入格式
输入的第一行包含一个正整数n。
第二行包含n 个正整数 A1,A2,···，An。
输出格式
输出一个整数表示需要的最小操作次数。
 */