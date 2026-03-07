package com.njx.qianZhuiHe;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long []A=new long[n];
        long sum=0;
        long s=0;
        for(int i=0;i<n;i++){
            A[i]=sc.nextLong();
            sum+=A[i];
        }

        for(int i=0;i<n;i++)
        {
            sum-=A[ i];
            s+=A[i]* sum;
        }
        System.out.println(s);
        sc.close();
    }
}
/*
给定 n 个整数 α1,α2,···,Qn，求它们两两相乘再相加的和,即:
S = a1 a2 + a1 · a3 + ... + a1· an + a2 · a3 + ... + an-2 -输入格式
输入的第一行包含一个整数n。
第二行包含n个整数a1,α2,···，αo
输出格式
输出一个整数S，表示所求的和。请使用合适的数据类型进行运算。
 */
