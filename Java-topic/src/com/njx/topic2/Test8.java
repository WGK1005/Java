package com.njx.topic2;

import java.util.*;

public class Test8 {
    // 最大数据范围
    static final int MAXN = 500005;

    // 存储排列
    static int[] a = new int[MAXN];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 读入 N
        int N = sc.nextInt();

        // 读入全排列（下标从1开始更符合比赛习惯）
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
        }

        // 由于答案可能很大（最多 N*(N+1)/2）
        // 必须使用 long 类型
        long ans = 0;

        // ------------------------------
        // 枚举左端点 L
        // ------------------------------
        for (int L = 1; L <= N; L++) {

            // 初始化当前区间的最大值和最小值
            int max = a[L];
            int min = a[L];

            // ------------------------------
            // 枚举右端点 R（从L开始往右扩展）
            // ------------------------------
            for (int R = L; R <= N; R++) {

                // 如果 R == L
                // 区间只有一个元素
                // 不需要更新 max/min
                if (R > L) {

                    // 更新当前区间最大值
                    if (a[R] > max) {
                        max = a[R];
                    }

                    // 更新当前区间最小值
                    if (a[R] < min) {
                        min = a[R];
                    }
                }

                // ------------------------------
                // 判断是否为连号区间
                // 条件：max - min == R - L
                // ------------------------------
                if (max - min == R - L) {
                    ans++;
                }
            }
        }

        // 输出答案
        System.out.println(ans);
    }
}
