package com.njx.Basic7;

import java.util.*;

public class Test12 {

    static final long MOD = 1000000007;

    // 快速幂
    static long pow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {

        int n = 10000;

        long a = pow(9, n);
        long b = pow(8, n);
        long c = pow(7, n);

        long ans = (a - 2 * b % MOD + c) % MOD;

        // 防止负数
        ans = (ans + MOD) % MOD;

        System.out.println(ans);
    }
}
/*
小蓝想要构造出一个长度为 10000 的数字字符串，有以下要求：
1.小蓝不喜欢数字0，所以数字字符串中不可以出现0；
2.小蓝喜欢数字3和7，所以数字字符串中必须要有3和7这两个数字。
请问满足题意的数字字符串有多少个？这个数字会很大，你只需要输出其对10”+7取余后的结果。
 */