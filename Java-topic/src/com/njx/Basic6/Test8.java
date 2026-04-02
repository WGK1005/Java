package com.njx.Basic6;

import java.util.*;
import java.io.*;

public class Test8 {

    static final int N = 17605;
    static final long MOD = 1000000007L;

    static long[] work = new long[N];

    // 快速幂（注意：这里和你原来一样，没有取模）
    static long pow1(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = N - 5;
        long m = (long) Math.sqrt(n);

        Arrays.fill(work, 0);

        // 埃氏筛
        for (long i = 2; i <= m; i++) {
            for (long j = i * 2; j <= N - 4; j += i) {
                work[(int) j] = 1;
            }
        }

        work[1] = 1;

        long ans = 1;

        for (long i = 2; i <= m; i++) {
            long cnt = 0;

            if (work[(int) i] == 0) { // 是质数
                for (long j = 1; ; j++) {
                    if (pow1(i, j) > 17600) break;
                    cnt++;
                }
            }

            if (cnt == 0) continue;

            ans = (ans * cnt) % MOD;
        }

        System.out.println(ans % MOD);
    }
}
/*
小蓝整理着阁楼上的旧物，偶然发现了一个落满灰尘的卡片箱。
打开箱子，里面整齐地摆放着17600 张卡片，每张卡片上都写有一个数字，恰好包含了从1到17600的所有正整数。
儿时的他热衷于收集各种卡牌，数量之多令人咋古。如今，再次翻阅这些尘封的记忆，小蓝不禁感慨万千。
他想起收藏家前辈的箴言：“收藏的魅力在于精粹，而非数量”。于是，他决定从这些卡牌中选取2025张，组成一套“互质藏卡”。
互质藏卡”的特点在于：任意两张卡片上的数字之间互质，即它们的最大公约数恒为1。
现在，请你帮小蓝计算，共有多少种不同的选取方案，使得选出的 2025 张卡片满足“互质藏卡”的条件。由于答案可能很大，你只需给出其对109+7取余后的结果即可。
注意：两个选取方案被认为是不同的，当且仅当它们所包含的数字集合不完全相同。
即，若存在至少一个数字出现在其中一个集合但不出现在另一个集合中，则这两个方案被视为不同。
 */