package com.njx.Basic4;

import java.util.*;
import java.io.*;
public class Test11 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] a;

    //数组f用来存储每个位置能够到达的最长路径长度
    static int[][] f; //使用了记忆化搜索的方式来实现对最长路径长度的计算

    static boolean[][] vis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        f = new int[n][m];
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
        scanner.close();
    }

    private static int dfs(int x, int y) {
        if (vis[x][y]) {
            return f[x][y];//访问过了，返回原来的位置
        }
        vis[x][y] = true;
        f[x][y] = 1;
        //在搜索时，如果当前位置已经被访问过，则直接返回该位置的最长路径长度；
        //否则，首先将当前位置标记为已访问，并初始化该位置的最长路径长度为 1。
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || a[nx][ny] >= a[x][y]) {
                continue;  //越界了或者值不满足
            }
            f[x][y] = Math.max(f[x][y], dfs(nx, ny) + 1);//更新，返回当前位置的最长路径长度
        }
        return f[x][y];
    }
}
/*
小蓝准备在一个空旷的场地里面滑行，这个场地的高度不一，小蓝用一个n 行m 列的矩阵来表示场地，矩阵中的数值表示场地的高度。
如果小蓝在某个位置，而他上、下、左、右中有一个位置的高度（严格）低于当前的高度，小蓝就可以滑过去，滑动距离为1。
如果小蓝在某个位置，而他上、下、左、右中所有位置的高度都大于等于当前的高度，小蓝的滑行就结束了。
小蓝不能滑出矩阵所表示的场地。
小蓝可以任意选择一个位置开始滑行，请问小蓝最多能滑行多远距离。
输入格式
输入第一行包含两个整数n，m，用一个空格分隔。
接下来 n 行，每行包含m 个整数，相邻整数之间用一个空格分隔，依次表示每个位置的高度。
输出格式
输出一行包含一个整数，表示答案。
 */