package com.njx.Basic3;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = new long[n + 1];

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextLong();
            sum += a[i];
        }

        // 如果 k == 1，直接输出总和
        if (k == 1) {
            System.out.println(sum);
            return;
        }

        // 计算最大子段和
        long cur = a[1];
        long maxSubarray = a[1];
        for (int i = 2; i <= n; i++) {
            cur = Math.max(a[i], cur + a[i]);
            maxSubarray = Math.max(maxSubarray, cur);
        }

        // 输出结果：总和 + (k-1) * 最大子段和
        System.out.println(sum + (k - 1) * maxSubarray);

        sc.close();
    }
}
/*
在数字社交媒体的浩瀚世界中，运营者小蓝负责维护一条情绪链路。这条链路由个用户节点依次排列而成，每个节点上记录着一个情绪值。
具体地，第个节点的情绪值为 α，其中 α是一个整数，可能为正，也可能为负。
为了改善整体情绪氛围，小蓝购买了一种名为“情绪放大器”的工具。该工具允许他选择一段至少包含一个用户节点的情绪连续区间，
并将这个区间内所有用户节点的情绪值都乘以一个整数k。只是，工具启动成本高昂，小蓝只能使用它一次。
现在，请你帮助小蓝计算，在经过这样一次操作后（一定要操作），所有用户节点的情绪值之和最大会是多少。
输入格式
第一行包含两个整数n和k，分别表示情绪链路的长度和放大器的倍数。
第二行包含 n 个整数 α1,α2,···,Qn，表示每个用户节点的情绪值。
输出格式
输出一行，包含一个整数，表示经过一次操作后，所有用户节点情绪值之和的最大可能值。
 */