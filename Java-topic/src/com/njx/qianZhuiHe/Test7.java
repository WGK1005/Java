package com.njx.qianZhuiHe;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取数列长度
        int n = sc.nextInt();
        int[] a = new int[n];

        // 读取数列元素
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 构建前缀和数组，prefixSum[i] 表示前 i 个元素的和（即 a[0] 到 a[i-1] 的和）
        // 这样区间 [L, R] 的和 = prefixSum[R+1] - prefixSum[L]
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + a[i];
        }

        int ans = 0;

        // 1. 先处理单元素区间 [i, i]
        // 对于任意单元素区间，乘积 = a[i]，和 = a[i]，恒成立
        ans += n;

        // 2. 处理长度 ≥ 2 的区间
        // 设置一个乘积上限，因为当乘积超过这个值时，就不可能等于和了
        // 和的最大可能值是 n * max(a[i])，这里假设 a[i] ≤ 2000，n ≤ 10^5，所以和 ≤ 2×10^8
        // 但为了安全，我们取一个稍大的值
        int LIMIT = 2000000; // 2×10^6

        // 枚举左端点 L
        for (int L = 0; L < n; L++) {
            long product = 1;  // 当前区间 [L, R] 的乘积

            // 从 L 开始向右扩展右端点 R
            for (int R = L; R < n; R++) {
                product *= a[R];  // 更新乘积

                // 如果乘积超过上限，后面的区间乘积只会更大，不可能等于和，直接跳出内层循环
                if (product > LIMIT) {
                    break;
                }

                // 计算区间长度
                int length = R - L + 1;

                // 长度=1的情况已经在前面处理过了，这里跳过避免重复计数
                if (length == 1) {
                    continue;
                }

                // 利用前缀和快速计算区间和
                long sum = prefixSum[R + 1] - prefixSum[L];

                // 判断是否满足乘积等于和
                if (product == sum) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
/*
给定一个数列 A=（α1,α2,···,αn)，问有多少个区间[L, R]满足区间内元素的乘积等于他们的和，即αL·αL+1···αR =aL + aL+1 +...+ ar。
输入描述
输入第一行包含一个整数n，表示数列的长度。
第二行包含 n 个整数，依次表示数列中的数 α1,α2,···，Qn。
输出描述
输出仅一行，包含一个整数表示满足如上条件的区间的个数。
 */