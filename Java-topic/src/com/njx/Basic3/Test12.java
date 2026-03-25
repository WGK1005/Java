package com.njx.Basic3;

import java.util.*;

public class Test12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int count=1;
        arr[0]=sc.nextInt();  //基准
        for(int i=1;i<n;i++){
            arr[i]=sc.nextInt();
            if((Math.abs(arr[i]) < Math.abs(arr[0]) && arr[i] > 0)
                    ||(Math.abs(arr[i]) > Math.abs(arr[0]) && arr[i] < 0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
长 100 厘米的细长直杆子上有 n 只蚂蚁。 它们的头有的朝左，有的朝右。
每只蚂蚁都只能沿看杆子向前爬，速度是1厘米/秒。
当两只蚂蚁碰面时，它们会同时掉头往相反的方向爬行。
这些蚂蚁中，有1只蚂蚁感冒了。并且在和其它蚂蚁碰面时，会把感冒传染给碰到的蚂蚁。
请你计算，当所有蚂蚁都爬离杆子时，有多少只蚂蚁患上了感冒。
输入描述
输入描述
第一行输入一个整数 n (1 < n < 50),表示蚂蚁的总数。
接着的一行是n 个用空格分开的整数 X;（-100 < X<
100)，X：的绝对值，表示蚂蚁离开杆子左边端点的距离。正值表示头朝右，负值表示头朝左，数据中不会出现0值,也不会出现两只蚂蚁占用同一位置。其中，第一个数据代表的蚂蚁感冒了。
 */