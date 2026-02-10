package com.njx.topic2;

/*糖果店的老板一共有 M 种口味的糖果出售。为了方便描述，我们将 M 种口味编号 1～ M。
小明希望能品尝到所有口味的糖果。遗憾的是老板并不单独出售糖果，而是K颗一包整包出售。
幸好糖果包装上注明了其中K颗糖果的口味，所以小明可以在买之前就知道每包内的糖果口味。
给定N包糖果，请你计算小明最少买几包，就可以品尝到所有口味的糖果。
输入描述
第一行包含三个整数N，M，K。
接下来 N 行每行K个整数T1,T2，···，TK，代表一包糖果的口味。
其中, 1 ≤ N ≤ 100,1 ≤ M ≤ 20,1 ≤ K≤ 20,1 ≤T ≤ M.
输出描述
输出一个整数表示答案。如果小明无法品尝所有口味，输出-1。
*/

import java.util.*;
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取 N（包数）, M（口味数）, K（每包糖果数）
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        // 用数组保存每一包糖果对应的“口味掩码”
        int[] bags = new int[N];

        // 读取每包糖果
        for (int i = 0; i < N; i++) {
            int mask = 0;
            for (int j = 0; j < K; j++) {
                int taste = sc.nextInt();
                // 将口味 taste 映射到第 (taste-1) 位
                mask |= (1 << (taste - 1));
            }
            bags[i] = mask;
        }

        // 所有口味都被覆盖时的状态
        int fullMask = (1 << M) - 1;

        // dp[mask]：得到 mask 这种口味状态所需的最少包数
        int[] dp = new int[1 << M];

        // 初始化 dp 为一个很大的数（表示不可达）
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 什么都没买时，状态是 0，需要 0 包
        dp[0] = 0;

        // 枚举所有状态
        for (int mask = 0; mask <= fullMask; mask++) {
            // 如果这个状态不可达，跳过
            if (dp[mask] == Integer.MAX_VALUE) continue;

            // 尝试买任意一包糖果
            for (int i = 0; i < N; i++) {
                int newMask = mask | bags[i];
                dp[newMask] = Math.min(dp[newMask], dp[mask] + 1);
            }
        }

        // 输出结果
        if (dp[fullMask] == Integer.MAX_VALUE) {
            System.out.println(-1); // 无法覆盖所有口味
        } else {
            System.out.println(dp[fullMask]);
        }
    }
}
