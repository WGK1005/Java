package com.njx.Basic;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[] b=new int[m];
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        int i=0,j=0;
        int sumA=a[ 0];
        int sumB=b[0];
        int ans=0;
        while(i<n && j<m){

            if(sumA==sumB){

                i++;
                j++;

                if(i<n) sumA=a[i];
                if(j<m) sumB=b[j];

            }
            else if(sumA<sumB){

                i++;
                sumA+=a[i];
                ans++;
            }
            else{

                j++;
                sumB+=b[j];
                ans++;

            }
        }

        System.out.println(ans);
    }
}
/*
小明发现有很多方案可以把一个很大的正整数拆成若干正整数的和。他采取了其中两种方案，分别将他们列为两个数组{a1,a2,..,an}和{b1,b2,·….,bm}。两个数组的和相同。定义一次合并操作可以将某数组内相邻的两个数合并为一个新数，新数的值是原来两个数的和。小明想通过若十次合并操作将两个数组变成一模一样，即n=m且对于任意下标2满足α=b。请计算至少需要多少次合并操作可以完成小明的目标。
输入格式
输入共3行。
第一行为两个正整数 n,m。
第二行为n个由空格隔开的整数 α1,α2，.,αn。
第三行为m个由空格隔开的整数b1，b2，··.,bm。
输出格式
输出共1行，一个整数。
 */