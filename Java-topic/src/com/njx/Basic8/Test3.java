package com.njx.Basic8;

import java.util.*;

public class Test3 {
    // 每个数字对应的笔画数
    static int[] mp = {
            13, // 0
            1,  // 1
            2,  // 2
            3,  // 3
            5,  // 4
            4,  // 5
            4,  // 6
            2,  // 7
            2,  // 8
            2   // 9
    };

    public static void main(String[] args) {

        int y = 2000, m = 1, d = 1;
        int ans = 0;

        while (true) {
            // 计算 YYYYMMDD 的笔画数
            int total = calc(y, m, d);

            if (total > 50) {
                ans++;
            }

            // 结束条件
            if (y == 2024 && m == 4 && d == 13) break;

            // 日期 +1
            d++;
            if (d > daysInMonth(y, m)) {
                d = 1;
                m++;
                if (m > 12) {
                    m = 1;
                    y++;
                }
            }
        }

        System.out.println(ans); // 4042
    }

    // 计算某一天的笔画数
    static int calc(int y, int m, int d) {
        int sum = 0;

        // 年
        sum += calcNum(y, 4);

        // 月（补零）
        sum += calcNum(m, 2);

        // 日（补零）
        sum += calcNum(d, 2);

        return sum;
    }

    // 计算一个数的笔画（指定位数，不足补0）
    static int calcNum(int x, int len) {
        int sum = 0;
        int[] digits = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            digits[i] = x % 10;
            x /= 10;
        }

        for (int d : digits) {
            sum += mp[d];
        }

        return sum;
    }

    // 判断某月有多少天
    static int daysInMonth(int y, int m) {
        if (m == 2) {
            return isLeap(y) ? 29 : 28;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        }
        return 31;
    }

    // 闰年判断
    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
