package com.njx.Basic8;

import java.util.*;

public class Test20 {
    static int n;
    static int[] sixCnt;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sixCnt = new int[n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int c = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '6') {
                    c++;
                }
            }
            sixCnt[i] = c;
        }

        int fullMask = (1 << n) - 1;
        memo = new int[1 << n];
        Arrays.fill(memo, -1);

        System.out.println(dfs(fullMask));
    }

    // 在 mask 未使用的数字中，最多能凑出多少个好数
    static int dfs(int mask) {
        if (mask == 0) {
            return 0;
        }
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int best = 0;

        // 固定一个元素，避免重复枚举
        int i = Integer.numberOfTrailingZeros(mask);
        int maskWithoutI = mask ^ (1 << i);

        // 不使用 i 组成好数
        best = Math.max(best, dfs(maskWithoutI));

        // 1 个数组成
        if (sixCnt[i] >= 6) {
            best = Math.max(best, 1 + dfs(maskWithoutI));
        }

        // 2 个数组成
        for (int j = i + 1; j < n; j++) {
            if ((maskWithoutI & (1 << j)) == 0) {
                continue;
            }
            int maskWithoutIJ = maskWithoutI ^ (1 << j);
            if (sixCnt[i] + sixCnt[j] >= 6) {
                best = Math.max(best, 1 + dfs(maskWithoutIJ));
            }

            // 3 个数组成
            for (int k = j + 1; k < n; k++) {
                if ((maskWithoutIJ & (1 << k)) == 0) {
                    continue;
                }
                if (sixCnt[i] + sixCnt[j] + sixCnt[k] >= 6) {
                    int maskWithoutIJK = maskWithoutIJ ^ (1 << k);
                    best = Math.max(best, 1 + dfs(maskWithoutIJK));
                }
            }
        }

        memo[mask] = best;
        return best;
    }
}

/*
我们将含有不少于6个6 的数视为一个好数。例如，
666666、162636465666是好数，12366666不是好数。
给定 n个正整数 ai，你可以将这些数分成若干组拼起来，每组内的数可以按任意顺序拼接，但一组最多只能有3个数。求最多可以得到多少个好数。
输入格式
输入的第一行包含一个正整数n。y
第二行包含n个正整数a1，a2，···，an，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数，表示最多可以得到的好数的数量。
 */