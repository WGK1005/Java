package com.njx.DP;

import java.util.*;

public class Test2 {
    static Scanner sc = new Scanner(System.in);
    //x偏移量以及y偏移量
    static int[][] shifting = {{0, 1}, {0, 2}, {0, 3},
            {1, 0}, {2, 0}, {3, 0}, {1, 1}, {2, 1}, {1, 2}};
    static int max_length = Integer.MIN_VALUE; //最大权值，先取最小值
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int[][] graph = new int[n][m]; //构建二维数组
    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        //从(0, 0)开始递归dfs寻找到(n - 1, m - 1)
        dfs(0, 0, graph[0][0]);
        System.out.println(max_length);
    }

    //深度遍历寻找到graph[i - 1][j - 1]最大权值，也就是最长距离
    static void dfs(int i, int j, int length) {
        if (i == n - 1 && j == m - 1) { //末点更新最大权值
            //更新最长长度
            max_length = Math.max(length, max_length);
        }
        //这里会寻找完一个方向然后继续寻找另一个方向，有数不清的递归次数...
        for (int k = 0; k < shifting.length; k++) {
            int dx = i + shifting[k][0];
            int dy = j + shifting[k][1];
            if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
                dfs(dx, dy, length + graph[dx][dy]); //递归深度遍历
            }
        }
    }
}

/*
小蓝在一个 n 行 m 列的方格图中玩一个游戏。
开始时，小蓝站在方格图的左上角，即第 1 行第1 列。
小蓝可以在方格图上走动，走动时，如果当前在第 r 行第c 列,他不能走到行号比 r 小的行，也不能走到列号比 c 小的列。同时，他一步走的直线距离不超过 3。
例如，如果当前小蓝在第 3 行第 5 列，他下一步可以走到第 3行第 6列、第3行第 7列、第3行第8列、第 4 行第5列、第4 行第6 列、第 4 行第 7 列、第 5 行第 5 列、第 5 行第 6列、第 6 行第 5 列之一。
小蓝最终要走到第 n 行第 m 列。
在图中，有的位置有奖励，走上去即可获得，有的位置有惩罚，走上去就要接受惩罚。奖励和惩罚最终抽象成一个权值，奖励为正，惩罚为负。
小蓝希望，从第 1 行第 1 列走到第 n 行第 m 列后，总的权值和最大。请问最大是多少？
输入描述
输入的第一行包含两个整数 n,m，表示图的大小。
接下来n行，每行m个整数，表示方格图中每个点的权值。
其中，1≤ n,m ≤ 100，－104 ≤权值≤ 104。
输出描述
输出一个整数，表示最大权值和。
 */