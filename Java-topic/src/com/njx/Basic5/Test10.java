package com.njx.Basic5;

import java.util.*;

public class Test10 {
    static int[] countDigits(int x) {
        int[] cnt = new int[10];
        while (x > 0) {
            cnt[x % 10]++;
            x /= 10;
        }
        return cnt;
    }

    static boolean check(int n) {
        int[] cntN = countDigits(n);
        int lenN = String.valueOf(n).length();

        for (int a = 1; a * a <= n; a++) {
            if (n % a != 0) continue;

            int b = n / a;

            // 剪枝：位数不匹配
            int lenA = String.valueOf(a).length();
            int lenB = String.valueOf(b).length();
            if (lenA + lenB != lenN) continue;

            int[] cntA = countDigits(a);
            int[] cntB = countDigits(b);

            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                if (cntA[i] + cntB[i] != cntN[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int ans = 0;

        for (int i = 1; i <= 1000000; i++) {
            if (check(i)) ans++;
        }

        System.out.println(ans);
    }
}
/*
混乘数字的定义如下:对于一个正整数n，如果存在正整数a,b，使得n=a×b，
而且a和b的十进制数位中每个数字出现的次数之和与n中对应数字出现次数相同，则称 n为混乘数字。
例如，对于正整数n= 126，存在α=6，b=21满足条件，因此 126是一个混乘数字。
又如，对于正整数n=180225，存在α=225，b= 801满足条件，因此180225是一个混乘数字。
请你帮助计算出，1～1000000 (含)之间一共有多少个数字是混乘数字。
 */