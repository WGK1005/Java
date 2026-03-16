package com.njx.DP;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < n; i++) {
            List<Integer> old = new ArrayList<>(set);
            for (int d : old) {
                set.add(d + w[i]);
                set.add(Math.abs(d - w[i]));
            }
        }
        System.out.println(set.size() - 1);
    }
}
/*
你有一架天平和 N 个砝码，这 N 个砝码重量依次是Wi, W2,... , Wn.
请你计算一共可以称出多少种不同的重量？注意砝码可以放在天平两边。
输入格式
输入的第一行包含一个整数N。
第二行包含 N 个整数：W1,W2,W3,···,Wv。
输出格式
输出一个整数代表答案。
 */