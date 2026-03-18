package com.njx.Basic;

import java.util.*;
//这是最通俗易懂的解法，大概是复杂了。通过率只有75，不过也行
public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int gcd = a[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        if(gcd!=1){
            System.out.println();
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) cnt1++;
        }

        // 如果已经有1
        if (cnt1 > 0) {
            System.out.println(n - cnt1);
            return;
        }

        // ================== Step3：找最短 gcd=1 子数组 =================
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int cur = a[i];

            for (int j = i; j < n; j++) {

                cur = gcd(cur, a[j]);

                if (cur == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        // ================== Step4：计算答案 ==================
        int ans = (minLen - 1) + (n - 1);

        System.out.println(ans);

    }
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
/*
给定一个数组，每次操作可以选择数组中任意两个相邻的元素∞,y 并将其 中的一个元素替换为 gcd(∞,y),其中 gcd(∞,y)表示和y的最大公约数。请问最少需要多少次操作才能让整个数组只含 1。
输入格式
输入的第一行包含一个整数n，表示数组长度。
第二行包含 n个整数α1,α2,···，αn，相邻两个整数之间用一个空格分隔。
输出格式
输出一行包含一个整数，表示最少操作次数。如果无论怎么操作都无法满 足要求,输出 一1 。
 */