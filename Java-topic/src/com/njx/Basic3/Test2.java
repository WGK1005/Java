package com.njx.Basic3;

import java.util.*;

public class Test2 {
    private static final int MOD = 1000000007;
    private static int n;
    private static long[][][] dp;

    // 检查同一列上下两个数字是否互质
    // up和down: 0表示1, 1表示5, 2表示6
    private static boolean check(int up, int down) {
        if (up == down) {
            // 相同数字时，只有1是互质的（因为gcd(1,1)=1）
            // 但这里up==down==0表示两个都是1，返回true
            // up==down==1（两个5）或up==down==2（两个6）返回false
            return up == 0;
        }
        // 不同数字一定互质（因为1与任何数互质，5和6互质）
        return true;
    }

    // 检查左右相邻的两个数字是否互质
    // last: 上一列的数字, now: 当前列的数字
    // 注意：last=3表示虚拟的上一列（第一列没有左边邻居，认为满足条件）
    private static boolean check2(int last, int now) {
        // 如果是第一列（last==3），或者当前数字是1，或者上一列数字是1，都满足互质
        if (last == 3 || now == 0 || last == 0) {
            return true;
        }
        // 否则，只有两个数字不同时才互质（因为5和5不互质，6和6不互质）
        return last != now;
    }

    // DFS记忆化搜索
    // pos: 当前正在填充的列号（从1开始）
    // lastUp: 上一列的上格子数字（0,1,2表示1,5,6，3表示第一列的特殊值）
    // lastDown: 上一列的下格子数字
    private static long dfs(int pos, int lastUp, int lastDown) {
        // 如果已经填完所有列，返回1种方案
        if (pos > n) {
            return 1;
        }

        // 如果已经计算过，直接返回
        if (dp[pos][lastUp][lastDown] != -1) {
            return dp[pos][lastUp][lastDown];
        }

        long ans = 0;
        // 枚举当前列上格子i和下格子j的所有可能
        // 0: 数字1, 1: 数字5, 2: 数字6
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 检查当前列上下是否互质
                if (!check(i, j)) continue;
                // 检查当前列上格子与上一列上格子是否互质
                if (!check2(lastUp, i)) continue;
                // 检查当前列下格子与上一列下格子是否互质
                if (!check2(lastDown, j)) continue;
                // 递归到下一列
                ans = (ans + dfs(pos + 1, i, j)) % MOD;
            }
        }

        // 记忆化存储
        dp[pos][lastUp][lastDown] = ans % MOD;
        return dp[pos][lastUp][lastDown];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        // 初始化DP数组，大小为 (n+2) x 4 x 4，初始值为-1表示未计算
        dp = new long[n + 2][4][4];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 从第1列开始，上一列用特殊值3表示（表示没有限制）
        long result = dfs(1, 3, 3);
        System.out.println(result);
    }
}
/*
在新建成的城市数学文化馆中，最引人注目的是一面宏大的展示墙。这面墙上嵌有一个特殊的矩形区域：
它由两行瓷砖构成，每行有 N个格子，整体呈现出一个 2 × N 的方格结构。
为了致敬数学家欧几里得对数论的贡献，
：他们计划使用三种特制的数字瓷砖一一分别印有 6、1 和 5，来填满这些格子，使得任意两个相邻瓷砖上的数字互质。
瓷砖之间共有两种相邻关系：横向相邻（同一行中左右相邻的瓷砖）和纵向相邻（同一列中上下相邻的瓷砖）。
无论是哪种相邻关系，它们所承载的数字都必须满足互质条件。
作为受邀的技术顾问，现在，请你计算出在严格遵循上述互质规则的前提下，共有多少种不同的瓷砖填充方法。
由于答案可能很大，你只需给出其对 10°+7 取余后的结果即可。
输入格式
输入一个整数N，表示矩形区域的列数。
输出格式
输出一个整数，表示符合互质条件的瓷砖填充方法的数量，对 10°+ 7 取余后的结果。
 */