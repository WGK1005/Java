package com.njx.Basic;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] A = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextLong();
        }

        int m = sc.nextInt();

        // 差分数组
        long[] diff = new long[n + 2];

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            diff[l] += 1;
            diff[r + 1] -= 1;
        }

        // 计算每个位置被覆盖次数
        long[] cnt = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            cnt[i] = cnt[i - 1] + diff[i];
        }

        // 计算原始总和
        long oldSum = 0;
        for (int i = 1; i <= n; i++) {
            oldSum += A[i] * cnt[i];
        }

        // 排序（从小到大）
        Arrays.sort(A, 1, n + 1);
        Arrays.sort(cnt, 1, n + 1);

        // 计算最大总和
        long newSum = 0;
        for (int i = 1; i <= n; i++) {
            newSum += A[i] * cnt[i];
        }

        // 输出增加量
        System.out.println(newSum - oldSum);
    }
}
/*
给定一个数组 A 和一些查询 L, R,求数组中第 L至第 R 个元素之和。
小蓝觉得这个问题很无聊，于是他想重新排列一下数组，使得最终每个查询结果的和尽可能地大。小蓝想知道相比原数组，所有查询结果的总和最多可以增加多少？
输入格式
输入第一行包含一个整数n。
第二行包含n 个整数 A1,A2，···，An，相邻两个整数之间用一个空格分隔。
第三行包含一个整数m表示查询的数目。
接下来m行，每行包含两个整数L、R，相邻两个整数之间用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */