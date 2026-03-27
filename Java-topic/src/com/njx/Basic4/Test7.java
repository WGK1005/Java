package com.njx.Basic4;

import java.util.*;
//说是动态规划，感觉更像是暴力枚举加上剪枝了
public class Test7 {
    static final int mod = 998244353;
    static int[][][][] dp = new int[10][10][10][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int res = 0;

        // 初始化边界
        for (int i = 1; i <= 9; i += 2) {
            for (int j = 0; j <= 9 && j <= (m - i); j += 2) {
                for (int k = 1; k <= 9 && k <= (m - i - j); k += 2) {
                    for (int l = 0; l <= 9 && l <= (m - i - j - k); l += 2) {
                        dp[i][j][k][l] = 1;//边界初始化为1
                    }}}}

        // 开始动态规划
        for (int i = 5; i <= n; i++) {//遍历数字的位数
            for (int p = i % 2; p <= 9; p += 2) {//遍历当前数字的奇数位数
                for (int j = (i + 1) % 2; j <= 9 && (j <= m - p); j += 2) {//遍历当前数字的偶数位数
                    for (int k = i % 2; k <= 9 && (k <= m - p - j); k += 2) {//遍历奇数
                        for (int l = (i + 1) % 2; l <= 9 && l <= (m - p - j - k); l += 2) {//遍历偶数
                            for (int q = i % 2; q <= 9 && q <= (m - p - j - k - l); q += 2) {//遍历最后一个奇数位
                                dp[j][k][l][q] += dp[p][j][k][l];//状态转移
                                dp[j][k][l][q] %= mod;
                            }
                            dp[p][j][k][l] = 0;//清空原有的值
                        }}}}}

        // 计算结果
        for (int j = (n + 1) % 2; j <= 9 && (j <= m); j += 2) {
            for (int k = n % 2; k <= 9 && (k <= m - j); k += 2) {
                for (int l = (n + 1) % 2; l <= 9 && l <= (m - j - k); l += 2) {
                    for (int q = n % 2; q <= 9 && q <= (m - j - k - l); q += 2) {
                        res += dp[j][k][l][q];//累加结果
                        res %= mod;
                    }}}}
        System.out.println(res);
    }
}
/*
小蓝最近在找一些奇怪的数，其奇数数位上是奇数，而偶数数位上是偶数。
同时，这些数的任意 5 个连续数位的和都不大于 m。例如当 m = 9 时，10101 和 12303 就是奇怪的数，而12345 和 11111 则不是。
小蓝想知道一共有多少个长度为 n 的上述的奇怪的数。你只需要输出答案对998244353取模的结果。
输入格式
输入一行包含两个整数n，m，用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */