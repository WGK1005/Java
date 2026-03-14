package com.njx.BaoLi;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  A= sc.nextInt();
        int  B= sc.nextInt();
        int  C= sc.nextInt();

        for(int i = 0; i < n; i++) A[i] = sc.nextInt();
        for(int i = 0; i < n; i++) B[i] = sc.nextInt();
        for(int i = 0; i < n; i++) C[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(C);

        long ans = 0;
        for(int i = 0; i < n; i++){
            int b= B[i];
            int countA = lowerBound(A,b);
            int countC = n - upperBound(C,b);

            ans += (long)countA * countC;
        }

        System.out.println(ans);
    }

    static int lowerBound(int[] arr,int target){

        int l=0,r=arr.length;

        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]<target) l=mid+1;
            else r=mid;
        }

        return l;
    }

    static int upperBound(int[] arr,int target){

        int l=0,r=arr.length;

        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]<=target) l=mid+1;
            else r=mid;
        }

        return l;
        }

    }
}
/*
给定三个整数数组
A = [A1, A2,..· AN],
B = [B1, B2,... BN],
C' = [Ci,C2,... Cn],
请你统计有多少个三元组（，，k）满足：
1. 1 ≤i,j,k≤ N;
2. A; < Bj < Ck。输入描述
第一行包含一个整数N。
第二行包含N个整数A1,A2，···AN。
第三行包含N个整数B1,B2，···BN。
第四行包含 N个整数C1,C2，···CN。
其中, 1 ≤ N ≤ 10,0 ≤ Ai,Bi,Ci ≤ 105。
输出描述
输出一个整数表示答案。
 */