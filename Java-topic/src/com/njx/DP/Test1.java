package com.njx.DP;

import java.util.*;

public class Test1 {
    static int n, m;
    static char[][] g = new char[6][6];
    static int ans = 0;

    static void dfs(int pos) {

        // 所有格子填完
        if (pos == n * m) {
            ans++;
            return;
        }

        int i = pos / m;
        int j = pos % m;

        // 放 O
        g[i][j] = 'O';
        dfs(pos + 1);

        // 尝试放 X
        g[i][j] = 'X';

        if (check(i, j)) {
            dfs(pos + 1);
        }

    }

    // 检查是否合法
    static boolean check(int i, int j) {

        // 横向检查
        if (j >= 2) {
            if (g[i][j] == 'X' && g[i][j - 1] == 'X' && g[i][j - 2] == 'X') {
                return false;
            }
        }

        // 纵向检查
        if (i >= 2) {
            if (g[i][j] == 'X' && g[i - 1][j] == 'X' && g[i - 2][j] == 'X') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dfs(0);

        System.out.println(ans);
    }
}
/*
题目描述
一个 N× M 的方格矩阵，每一个方格中包含一个字符O或者字符X。
要求矩阵中不存在连续一行3个×或者连续一列3个×。
问这样的矩阵一共有多少种？
输入描述
输入一行包含两个整数 N, M (1 ≤ N, M ≤ 5)。
输出描述
输出一个整数代表答案。
 */