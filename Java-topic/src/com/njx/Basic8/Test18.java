package com.njx.Basic8;

import java.util.*;

public class Test18 {
    // 统计2因子
    static int count2(int x) {
        int cnt = 0;
        while (x % 2 == 0) {
            x /= 2;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            total += count2(a[i]);
        }

        // 已经满足
        if (total >= k) {
            System.out.println(0);
            return;
        }

        // 存每次增加一个2的最小代价
        List<Integer> costs = new ArrayList<>();

        for (int x : a) {
            int lowbit = x & -x;
            costs.add(lowbit);
        }

        Collections.sort(costs);

        int need = k - total;
        long ans = 0;

        for (int cost : costs) {
            ans += cost;
            need--;

            if (need <= 0) {
                System.out.println(ans);
                return;
            }
        }

        System.out.println(-1);
    }
}
/*
小明很喜欢2 的幂，所以他想对一个长度为 n的正整数数组a1, a2，···，an进行改造。
他可以进行如下操作任意多次（可以是0 次）：任选一个数ai加上任意正整数，但不能使加完后的结果超过105。
在操作任意次后，小明希望所有数的乘积是2′的倍数。他想知道总共需要加的数的总和至少是多少？
输入格式
输入共两行。
第一行为两个正整数n, k。
第二行为n个由空格分开的正整数a1，a2，···，an。
输出格式
输出共1行，一个整数，表示需要加的数的总和的最小值。如果不能满足条件，输出一1。
 */
