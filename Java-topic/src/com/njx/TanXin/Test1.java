package com.njx.TanXin;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        // 遍历整个地图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 如果当前是地雷
                if (map[i][j] == 1) {
                    System.out.print(9 + " ");
                } else {

                    int count = 0;  // 统计周围地雷数量

                    // 检查八个方向
                    for (int k = 0; k < 8; k++) {

                        int newX = i + dx[k];
                        int newY = j + dy[k];

                        // 边界判断（防止数组越界）
                        if (newX >= 0 && newX < n &&
                                newY >= 0 && newY < m) {

                            if (map[newX][newY] == 1) {
                                count++;
                            }
                        }
                    }
                    System.out.print(count + " ");

                }
            }
            System.out.println();

        }
    }
}
/*
在一个 n 行 m 列的方格图上有一些位置有地雷，另外一些位置为空。
请为每个空位置标一个整数，表示周围八个相邻的方格中有多少个地雷。
输入描述
输入的第一行包含两个整数n，m。
第 2 行到第 n + 1 行每行包含 m 个整数，相邻整数之间用一个空格分隔。如果对应的整数为0，表示这一格没有地雷。如果对应的整数为1，表示这一格有地雷。
其中，1 ≤ n, m ≤ 100 分钟后还是在当天。
输出描述
输出 n 行，每行 m个整数，相邻整数之间用空格分隔。
对于没有地雷的方格，输出这格周围的地雷数量。对于有地雷的方格，输出9。
 */