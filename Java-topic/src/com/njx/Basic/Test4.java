package com.njx.Basic;

import java.util.*;
//虽然通过率只有60但是也够用
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int maxSum = -1;

        // 枚举所有三元组
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = nums[i] + nums[j] + nums[l];

                    // 检查和是否是 K 的倍数
                    if (sum % k == 0) {
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}

/*
众所周知，小葱同学擅长计算，尤其擅长计算一个数是否是另外一个数的倍数。但小葱只擅长两个数的情况，当有很多个数之后就会比较苦恼。现在小葱给了你n个数，希望你从这n个数中找到三个数，使得这三个数的和是K的倍数，且这个和最大。数据保证一定有解。
输入描述
第一行包括 2 个正整数 n，K。
第二行n个正整数，代表给定的n个数。
其中，1 ≤n ≤ 10°,1 ≤ K ≤ 10²，给定的n 个数均不超过 10°。
输出描述
输出一行一个整数代表所求的和。
 */