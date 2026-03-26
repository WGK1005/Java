package com.njx.Basic3;

import java.util.*;

public class Test15 {
        static int n;
        static int[] col; // col[i] = 第i行的列
        static int ans = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            col = new int[n];

            dfs(0);

            System.out.println(ans);
        }

        // 当前处理第 row 行
        static void dfs(int row) {
            // 放完了
            if (row == n) {
                ans++;
                return;
            }

            // 枚举这一行的列
            for (int c = 0; c < n; c++) {
                if (check(row, c)) {
                    col[row] = c;
                    dfs(row + 1);
                }
            }
        }

        // 检查是否合法
        static boolean check(int row, int c) {
            for (int i = 0; i < row; i++) {
                int j = col[i];

                // 同列
                if (j == c) return false;

                // 同对角线
                if (Math.abs(row - i) == Math.abs(c - j)) {
                    // 行差必须 >= 3
                    if (Math.abs(row - i) < 3) return false;
                }
            }
            return true;
    }
}
/*
有一个 n × n 的国际象棋棋盘（n 行 n 列的方格图），请在棋盘中摆放n个受伤的国际象棋皇后，要求：
1. 任何两个皇后不在同一行。
2. 任何两个皇后不在同一列。
3.如果两个皇后在同一条 45 度角的斜线上，这两个皇后之间行号的差值至少为 3。
请问一共有多少种摆放方案。
输入描述
输入的第一行包含一个整数n。其中，1≤≤ 10.
输出描述
输出一个整数，表示答案。
 */