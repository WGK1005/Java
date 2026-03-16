package com.njx.DP;

import java.util.*;

public class Test6 {
    static int n = 8, m = 8;
    static long[][] dp = new long[9][1 << 8];

    static void dfs(int row, int col, int cur, int next) {
        if (col >= m) {
            dp[row + 1][next] += dp[row][cur];
            return;
        }

        if ((cur & (1 << col)) != 0) {
            dfs(row, col + 1, cur, next);
        } else {
            dfs(row, col + 1, cur, next | (1 << col));
            if (col + 1 < m && (cur & (1 << (col + 1))) == 0)
                dfs(row, col + 2, cur, next);
        }
    }

    public static void main(String[] args) {

        dp[0][0] = 1;

        for (int i = 0; i < n; i++)
            for (int s = 0; s < (1 << m); s++)
                if (dp[i][s] > 0)
                    dfs(i, 0, s, 0);

        System.out.println(dp[n][0]);
    }
}
/*
小蓝有一个国际象棋的棋盘，棋盘的大小为 8 × 8，即由 8 行 8 列共 64 个方格组成。棋盘上有美丽的图案，因此棋盘旋转后与原来的棋盘不一样。
小蓝有很多相同的纸片，每张纸片正好能覆盖棋盘的两个相邻方格。小蓝想用32张纸片正好将棋盘完全覆盖，每张纸片都覆盖其中的两个方格。
小蓝发现，有很多种方案可以实现这样的覆盖。如果棋盘比较小，方案数相对容易计算，比如当棋盘是2× 2 时有两种方案，当棋盘是 4 × 4 时有 36 种方案。但是小蓝算不出他自己的这个 8 × 8 的棋盘有多少种覆盖方案。
请帮小蓝算出对于这个8×8的棋盘总共有多少种覆盖方案。
 */