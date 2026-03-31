package com.njx.Basic6;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        //使用滚动数组进行降维
        int[][] dp = new int[a + 1][b + 1];
        for(int i = 1; i <= n; i++) {
            int v = weights[i - 1];
            for(int j = a; j >= 0; j--) { //注意是倒序，倒序遍历背包容量不会出现重复
                for(int k = b; k >= 0; k--) { //注意是倒序
                    if(j >= v) {
                        dp[j][k] = Math.max(dp[j][k],dp[j - v][k] + v);
                    }
                    if(k >= v) {
                        dp[j][k] = Math.max(dp[j][k],dp[j][k - v] + v);
                    }
                }
            }
        }
        System.out.println(dp[a][b]);
        sc.close();
    }
}
/*
钢厂有一辆用于运送废旧钢材的火车，它具有两节车厢，其中车厢1的最大载重量为A，车厢2的最大载重量为B。
现在一共有N件废旧钢材需要被运输，其中第i件钢材的重量为ωi。为了最大化运输效率，车长想要一次性运输走重量尽可能多的钢材，
请你帮助车长计算出一次运输最多可以带走多大重量的钢材。
每件钢材都是独立的不可分割的，只能被放置在某一节车厢中。在装载钢材时只需要考虑重量条件即可。
输入格式
输入的第一行包含三个整数N，A，B，用一个空格分隔，分别表示钢材的数目以及两节车厢的最大载重。
第二行包含N个整数，分别表示W1，W2，…，Wn，相邻两个整数之间使用一个空格分隔。
输出格式
输出一个整数表示答案。
 */