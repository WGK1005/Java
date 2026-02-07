package com.njx.topic1;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        //X 星球的考古学家发现了一批古代留下来的密码。
        //
        //这些密码是由 A、B、C、D 四种植物的种子串成的序列。
        //
        //仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
        //
        //由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。
        //
        //你的任务是：给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。
        //文章核心：最少删除/插入使字符串成为回文
        //模板
        //1. 计算最长回文子序列 LPS
        //2. 答案 = 字符串长度 - LPS

                Scanner sc = new Scanner(System.in);

                String s = sc.nextLine();
                int n = s.length();

                // dp[i][j] 表示 s[i..j] 的最长回文子序列长度
                int[][] dp = new int[n][n];

                // 1. 初始化：单个字符
                for (int i = 0; i < n; i++) {
                    dp[i][i] = 1;
                }

                // 2. 区间 DP
                // i 从后往前，j 从前往后
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = i + 1; j < n; j++) {
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else {
                            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                        }
                    }
                }

                // 最长回文子序列长度
                int lps = dp[0][n - 1];

                // 最少脱落（删除）数量
                int result = n - lps;

                System.out.println(result);

                sc.close(); // Scanner 关闭要在 main 里面
            }
        }
