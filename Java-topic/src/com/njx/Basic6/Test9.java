package com.njx.Basic6;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        int max = 2025;
        long ascendingCount = 0;
        for (int b = 2; b < max; b++) {
            int left = b - 1;
            int right = max - b;
            ascendingCount += Math.min(left, right);
        }
        long total = ascendingCount * 2;
        System.out.println(total);
    }
}
/*
等差数列是一种常见的数学数列，其任意相邻两项的差均为固定常数，称为公差。
例如，{1，3，5}是一个公差为2的等差数列，而{2，3，5}不是等差数列。
现在，小蓝想知道，如果从1到2025的整数中选取3个不同的数，那么可以组成多少种不同的、长度为3的等差数列？
两个等差数列不同当且仅当它们至少有一项不同。例如，{1，2，3}和{2，3，4}是不同的等差数列，{1，2，3}和{3，2，1}也是不同的等差数列。
 */