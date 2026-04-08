package com.njx.Basic8;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        int[] a = new int[2025];
        for (int i = 2; i <= 2024; i++) {
            int t = i;
            for (int j = 2; j <= t / j; j++) {
                while (t % j == 0) {
                    a[j]++;
                    t /= j;
                }
            }
            if (t > 1) a[t]++;
        }
        long ans = 1;
        for (int i = 2; i <= 2024; i++) {
            if (a[i] != 0) {
                int t = a[i] / 61;
                if (t != 0) {
                    ans *= (t + 1);
                }
            }
        }
        System.out.println(ans);
    }
}

/*
若—个正整数n 满足n61 整除 2024！，即 2024！除以n61的余数为0，则称n为“儿童数”。
现在，请你计算在区间[1，∞内一共有多少个“儿童数”。
 */