package com.njx.Basic4;

import java.util.*;
import java.math.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 读取矩阵的行数 n 和列数 m
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        // 创建字符矩阵存储输入的字符
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = scan.next();
            for (int j = 0; j < m; j++) {
                chars[i][j] = str.charAt(j);
            }
        }
        
        // 创建三个二维数组，分别记录三个方向的连续相同字符长度
        // a[i][j]: 从 (i,j) 向左上方向 (i-1,j-1) 的连续相同字符长度
        // b[i][j]: 从 (i,j) 向右上方向 (i-1,j+1) 的连续相同字符长度
        // c[i][j]: 从 (i,j) 向下方向 (i+1,j) 的连续相同字符长度
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int[][] c = new int[n][m];
        
        // 初始化三个数组，所有位置初始值为 1（自身）
        for (int[] row : a) {
            Arrays.fill(row, 1);
        }
        for (int[] row : b) {
            Arrays.fill(row, 1);
        }
        for (int[] row : c) {
            Arrays.fill(row, 1);
        }
        
        // 动态规划计算左上方向 (↖) 的连续相同字符长度
        // 如果当前字符与左上角字符相同，则累加左上角的值
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (chars[i][j] == chars[i - 1][j - 1]) {
                    a[i][j] += a[i - 1][j - 1];
                }
            }
        }
        
        // 动态规划计算右上方向 (↗) 的连续相同字符长度
        // 如果当前字符与右上角字符相同，则累加右上角的值
        for (int i = 1; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                if (chars[i][j] == chars[i - 1][j + 1]) {
                    b[i][j] += b[i - 1][j + 1];
                }
            }
        }
        
        // 动态规划计算向下方向 (↓) 的连续相同字符长度
        // 如果当前字符与下方字符相同，则累加下方的值
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (chars[i][j] == chars[i + 1][j]) {
                    c[i][j] += c[i + 1][j];
                }
            }
        }
        
        // 遍历所有位置，计算能构成字母的最大长度
        // 对于每个位置，取三个方向的最小值减 1（因为中心点被重复计算）
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 以 (i,j) 为中心能构成的字母长度 = min(左上，右上，下) - 1
                ans = Math.max(ans, Math.min(a[i][j], Math.min(b[i][j], c[i][j])) - 1);
            }
        }
        
        // 输出结果
        System.out.print(ans);
        scan.close();
    }
}
/*
对于一个字符矩阵，其中的一些字符构成字母是指存在一个中间字符，从这个中间字符向下、向左上（45度）、向右上（45 度）的字符都与中间的字符相同。
字母的长度指同时向 3 个方向的相同字母延伸的最大距离。
例如，下图中所有的 1 组成一个字母，长度为 3。
又如，下图中以第5 行第6 列为中心也构成一个字母（由字符A 构成），长度为 1。
再如，下图中以第 4 行第3 列为中心也构成一个字母（由字符0 构成），长度为2。
给定一个字符矩阵，请找出能构成字母的最大长度，如果无法构成字母，请输出 0。
输入格式
输入的第一行包含两个整数n,m，用一个空格分隔，表示字符矩阵的行数和列数。
接下来 n 行，每行包含 m 个字符，表示字符矩阵。
输出格式
输出一行包含一个整数，表示答案。
 */