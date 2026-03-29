package com.njx.Basic4;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

//首先，题目要求从数组中选择一个子集，使得该子集的元素之和为偶数，同时剩余元素的和也为偶数。这意味着所选子集中的奇数个数必须为偶数，因为偶数加偶数仍为偶数，奇数加奇数为偶数，但奇数加偶数为奇数。
//
//算法步骤如下：
//
//遍历数组，统计奇数的个数。
//如果奇数的个数为奇数，则无法满足条件，直接输出0。
//如果奇数的个数为偶数，考虑两种情况：
//若数组中没有奇数，则答案为 2 的 n 次方，其中 n 为数组的长度。
//若数组中有奇数，则答案为 2 的 n-1 次方，因为其中一个奇数可以单独构成一个子集，而其余奇数需要成对出现在不同的子集中，这样才能保证剩余元素之和为偶数。
public class Test15 {
    static BigInteger BIG_TWO = new BigInteger("2");

    static BigInteger BIG_MOD = new BigInteger("1000000007");

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 共 T 组数据
        int T = in.nextInt();
        // 存储答案
        BigInteger[] ans = new BigInteger[T];

        // 开始计算每组数据的答案
        for (int i = 0; i < T; i++) {

            // 每组数据的大小为n
            int n = in.nextInt();
            // 数组arr用来存储每组数据
            int[] arr = new int[n];

            // 输入每组数据，并统计该组数据中奇数的个数
            int odd = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
                if (arr[j] % 2 == 1) {
                    ++odd;
                }
            }

            // 若该组数据中有奇数个奇数，则无需计算，肯定没有符合条件的组合，答案为 0
            if ((odd & 1) == 1) {
                ans[i] = new BigInteger("0");
                continue;
            }

            // 能运行到这里，就证明有偶数个奇数（有可能是0个奇数，因此需要判断，并且注意要模以1000000007）
            if(odd == 0) {
                // 如果该组数据中没有奇数，则答案为2的n次方
                ans[i] = (BIG_TWO.pow(n)).mod(BIG_MOD);
            } else {
                // 如果该组数据中有偶数个奇数，则答案为2的n-1次方
                ans[i] = (BIG_TWO.pow(n-1)).mod(BIG_MOD);
            }
        }

        // 输出每组数据的答案
        for(BigInteger cur : ans) {
            System.out.println(cur);
        }

        in.close();
    }
}
/*
小蓝有一个长度为N的数组A= [A0，A1，…,AN-1]。现在小蓝想要从A对应的数组下标所构成的集合Ⅰ=0,1,2，…,N一1中找出—个子集R1，
那么R1在Ⅰ中的补集为 R2。记 S1 = ∑r∈R1 Ap ， S2 = ∑r∈R2 Ap 1我们要求S₁和S2均为偶数，请问在这种情况下共有多少种不同的R1。
当R1或R2为空集时我们将S1或S2视为0
输入格式
第一行一个整数T，表示有T组数据。
接下来输入T 组数据，每组数据包含两行：第一行一个整数N，表示数组 A 的长度；第二行输入N 个整数从左至右依次为A0，A1，…，AN-1，相邻元素之间用空格分隔。
输出格式
对于每组数据，输出一行，包含一个整数表示答案，答案可能会很大，你需要将答案对1000000007 进行取模后输出。
 */