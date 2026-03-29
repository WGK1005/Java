package com.njx.Basic5;

import java.util.*;
//二分方法
public class Test3 {
    public static void main(String[] args) {
        // 思路：先将A和B数组进行排序，min=A1+B1,max=An+Bm
        // 用二分，在min和max中有一个mid,看A和B数组中元素相加组合有多少（sum）个满足条件（<=mid）
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long k=sc.nextLong();
        long [] A=new long[n+1];
        long [] B =new long[m+1];
        for(int i=1;i<=n;i++){
            A[i]=sc.nextInt();
        }
        for(int i=1;i<=m;i++){
            B[i]=sc.nextInt();
        }
        //将A序列从索引0-索引n中的数进行排序，不包括n+1
        Arrays.sort(A,0,n+1);
        Arrays.sort(B,0,m+1);
        long l=A[1]+B[1],r=A[n]+B[m],ans=0;
        while(l<=r){
            long mid=l+(r-l)/2; //防止溢出
            long sum=0; //记录满足条件的组合数量
            for(int i=1;i<=n;i++){
                int low=1,high=m,count=0;
                //在数组B中查找所有能和A[i]相加<=mid元素的数量
                //作用：计算所有可能的A和B的元素组合中，哪些组合的和小于等于一个给定的值mid
                while(low<=high){
                    int mid2=low+(high-low)/2;
                    if(A[i]+B[mid2]<=mid){
                        //count记录的是满足条件B中元素的索引
                        count=mid2; //更新count
                        low=mid2+1;
                    }else{
                        high=mid2-1;
                    }
                }
                sum+=count;
            }
            if(sum>=k){
                ans=mid; //更新mid
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
//这是最简单的思路导致只能通过40，这题应该用二分
/*public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        int[] C = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[index++] = A[i] + B[j];
            }
        }
        Arrays.sort(C);
        System.out.println(C[k - 1]);
    }
}
*/

/*
给定两个序列A，B，长度分别为n，m。
设另有一个序列C中包含了A，B中的数两两相加的结果（C中共有n ×m个数)。问C中第K小的数是多少。
请注意重复的数需要计算多次。例如 1，1，2，3中，最小和次小都是1，而3是第4小。
输入格式
输入的第一行包含三个整数n，m，K，相邻两个整数之间使用一个空格分隔。
第二行包含n个整数，分别表示A1，A2，···，An，相邻两个整数之间使用一个空格分隔。
第三行包含m个整数，分别表示 B1，B2，·，Bm，相邻两个整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */