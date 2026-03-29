package com.njx.Basic5;

import java.util.*;
import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // 使用 BufferedReader 读取输入
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        
        // 读取字符串并转换为字符数组
        char[] chars = scanner.readLine().trim().toCharArray();
        
        // record 数组用于存储每个字符的价值 (a=1, b=2, ..., z=26)
        int[] record = new int[chars.length];
        int index = 0;
        for (char aChar : chars) {
            record[index++] = aChar - 'a' + 1;
        }
        
        // 动态规划数组 dp[i][0] 表示不选第 i 个字符时的最大价值
        // dp[i][1] 表示选择第 i 个字符时的最大价值
        int[][] dp = new int[chars.length][2];
        
        // 初始化第一个字符的状态
        dp[0][0] = 0;              // 不选第一个字符，价值为 0
        dp[0][1] = record[0];      // 选第一个字符，价值为该字符的价值
        
        // 动态规划填表
        for (int i = 1; i < record.length; i++) {
            // 不选第 i 个字符时，前一个字符可选可不选，取最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            
            // 选第 i 个字符时，由于是松散子序列，第 i-1 个字符不能选
            // 所以只能从 dp[i-1][0] 转移过来
            dp[i][1] = dp[i - 1][0] + record[i];
        }
        
        // 最终结果是最后一个字符选或不选的最大值
        System.out.println(Math.max(dp[record.length - 1][0], dp[record.length - 1][1]));
        
        // 关闭资源
        scanner.close();
    }
}
/*
给定一个仅含小写字母的字符串ｓ，假设ｓ的一个子序列 t的第个字符对应了原字符串中的第p个字符。
我们定义ｓ的一个松散子序列为：对于i  1总是有pi — Pi-1 ≥2。设一个子序列的价值为其包含的每个字符的价值之和(a～z分别为1~26)。
求ｓ的松散子序列中的最大价值。
输入格式
输入一行包含一个字符串 δ。
输出格式
输出一行包含一个整数表示答案。
 */