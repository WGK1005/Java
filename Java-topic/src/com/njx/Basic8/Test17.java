package com.njx.Basic8;

import java.util.*;

public class Test17 {
    static class Top2 {
        int first;
        int second;

        void add(int len) {
            if (len >= first) {
                second = first;
                first = len;
            } else if (len > second) {
                second = len;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Map<Integer, Top2> map = new HashMap<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && a[j + 1] == a[i]) {
                j++;
            }
            int len = j - i + 1;
            Top2 t = map.computeIfAbsent(a[i], k -> new Top2());
            t.add(len);
            i = j + 1;
        }

        long ans = 0;
        for (Map.Entry<Integer, Top2> e : map.entrySet()) {
            long value = e.getKey();
            Top2 t = e.getValue();
            long bestLen = t.first + t.second; // 一次翻转最多把同值的两段拼接在一起
            ans = Math.max(ans, value * bestLen);
        }

        System.out.println(ans);
    }
}
/*
小明生成了一个长度为n的正整数数组a1，a2，···，an，他可以选择连续的一段数al，al+1，···，ap，
如果其中所有数都相等即 al = al+1 = ·= ap，那么他可以获得(r —l +1)×ai的分数。
在选择之前，为了让分数尽可能大，他决定先选择数组中的一段区间，对其进行左右翻转。他想知道在对数组进行翻转之后他能获得的最大分数是多少？
提示：当翻转al到ap这段区间后，整个数组会变为：
A1, a2q • · • , al−1, ar, Ar−19 · · · , al+19 Al, Ar+19 • · • , An
输入格式
输入共两行。
 第一行为一个正整数n。
● 第二行为n个由空格分开的正整数 a1，a2，···，an。
输出格式
输出共1行，一个整数表示答案。
 */