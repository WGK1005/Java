package com.njx.Basic7;

import java.util.*;

public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 计算满足条件的格子对数量
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += check(grid, i, j, n, m);
            }
        }

        System.out.println(count);
    }

    private static int check(int[][] grid, int i, int j, int n, int m) {
        int count = 0;
        int value = grid[i][j];

        // 检查右下方
        for (int k = 1; i + k < n && j + k < m; k++) {
            if (grid[i + k][j + k] == value) {
                count++;
            }
        }

        // 检查左下方
        for (int k = 1; i + k < n && j - k >= 0; k++) {
            if (grid[i + k][j - k] == value) {
                count++;
            }
        }

        // 检查右上方
        for (int k = 1; i - k >= 0 && j + k < m; k++) {
            if (grid[i - k][j + k] == value) {
                count++;
            }
        }

        // 检查左上方
        for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
            if (grid[i - k][j - k] == value) {
                count++;
            }
        }

        return count;
    }
}
/*
小蓝正在和朋友们玩一种新的连连看游戏。在一个n×m的矩形网格中，每个格子中都有一个整数，第行第j列上的整数为Ai,j。
玩家需要在这个网格中寻找一对格子(a, b)一(c, d) 使得这两个格子中的整数Aa,b 和 Ac,d相等，且它们的位置满足 |a一c|= |b一d|>0。
请问在这个n×m的矩形网格中有多少对这样的格子满足条件。
输入格式
输入的第一行包含两个正整数n，m，用一个空格分隔。接下来n行，第i行包含m个正整数
Ai,1，Ai,2，，Ai,m，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */