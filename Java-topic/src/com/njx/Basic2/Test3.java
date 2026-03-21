package com.njx.Basic2;

import java.util.*;

public class Test3 {
    static int cal(String s1, String s2) {
        int m = s1.length();
        s1 += s1;
        s2 += s2;
        int[][] dp = new int[2 * m + 1][2 * m + 1];// dp[i][j]: 以s1[i]和s2[j]结尾的最长公共子串长度
        int maxLen = 0;
        for (int i = 1; i <= 2 * m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= 2 * m; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return Math.min(maxLen, m);
    }
    static class UnionSet {
        int[] root;

        UnionSet(int n) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        boolean union(int x, int y) {
            int rx = find(x), ry = find(y);
            root[rx] = ry;
            return rx == ry;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) strs[i] = sc.next();
        // 求边权
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new int[]{i, j, cal(strs[i], strs[j])});
            }
        }
        edges.sort((a, b) -> b[2] - a[2]);
        // 求最大生成树
        UnionSet set = new UnionSet(n);
        int choose = 0, ans = 0;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            int u = edge[0], v = edge[1], w = edge[2];
            if (set.union(u, v)) continue;
            ans += w;
            if (++choose == n - 1) break;
        }
        System.out.println(ans);
    }
}
/*
方
小蓝想制作一个吊坠，他手上有 n 个长度为 m 的首尾相连的环形字符串{s1,S2,···，Sn}，他想用 n－1 条边将这n个字符串连接起来做成吊坠，要求所有的字符串连完后形成一个整体。连接两个字符串S，;的边的边权为这两个字符串的最长公共子串的长度（可以按环形旋转改变起始位置，但不能翻转），小蓝希望连完后的这  －1 条边的边权和最大，这样的吊坠他觉得最好看，请计算最大的边权和是多少。
输入格式
输入的第一行包含两个正整数n，m，用一个空格分隔。
接下来n 行，每行包含一个长度为 m的字符串，分别表示$1,$2,... ,Sn o
输出格式
输出一行包含一个整数表示答案。
 */