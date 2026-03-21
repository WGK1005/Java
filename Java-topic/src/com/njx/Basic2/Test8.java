package com.njx.Basic2;

import java.util.*;
//通过率只有80，感觉这个都很难写出。
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        // 去重（关键优化）
        ArrayList<Integer> list = new ArrayList<>();
        list.add(h[0]);
        for (int i = 1; i < n; i++) {
            if (h[i] != h[i - 1]) {
                list.add(h[i]);
            }
        }

        int m = list.size();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = list.get(i);

        int ans = Integer.MAX_VALUE;

        // 枚举最终高度 H
        for (int i = 0; i < m; i++) {
            int H = a[i];

            int cnt = 0; // 段数
            int j = 0;

            while (j < m) {
                if (a[j] == H) {
                    j++;
                    continue;
                }

                // 遇到一段 != H
                cnt++;
                while (j < m && a[j] != H) j++;
            }

            ans = Math.min(ans, cnt * H);
        }

        System.out.println(ans);
    }
}
/*
小蓝作为一个二维生物快乐地生活在二维坐标系中，他最近得到了一块土地，他想把这块土地整平用于修建花园。具体来说，这块土地从左到右长度为 n 格，第 格的高度为 h（i ∈ [1, n])。小蓝每次可以花费代价 w 将一段连续的区间
[,r] 中的土地高度都变为 w，其中 l ≤ r，这段区间需要满足以下三组条件之一：
1. l = 1,r < n, 且对于i ∈ [,r] 有 h ≠ hr+1, 此时代价w = hr+1;
2. l > 1,r = n, 且对于i ∈ [l,r] 有 h; ≠ h-1, 此时代价w =hl-1i
3. 1 < l ≤ r < n, h-1 = hr+1, 且对于i ∈ [l,r] 有hi ≠ hl-1, 此时代价 w = hl-1 = hr+1。
小蓝希望在若干次操作之后将这块土地整平，即所有格子的高度都相等，并且花费的代价总和最小。请你帮助他计算一下最小花费。一个格子最多被整平一次。
输入格式
输入的第一行包含一个正整数n。
第二行包含 n 个正整数 h1,h2,···，hn，相邻整数之间使用一个空格分隔。
输出格式
山行句今人敷数丰二处安
 */