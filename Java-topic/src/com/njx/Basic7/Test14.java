package com.njx.Basic7;

import java.util.*;

public class Test14 {
        static int n, m;
        static int[] L;

        // 判断是否可行
        static boolean check(int x) {
            long cuts = 0;

            for (int i = 0; i < n; i++) {
                cuts += (L[i] - 1) / x;
            }

            return cuts <= m;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            m = sc.nextInt();

            L = new int[n];
            int max = 0;

            for (int i = 0; i < n; i++) {
                L[i] = sc.nextInt();
                max = Math.max(max, L[i]);
            }

            int left = 1, right = max;
            int ans = max;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (check(mid)) {
                    ans = mid;
                    right = mid - 1; // 尝试更小
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }
/*
给定n根木棒，第i根木棒的长度为Li。每次你可以选择任意一根木棒并将其切成两段，切完后两段的长度都必须为整数。
请问，如果一共切m次，在所有的方案中，切完后木棒中最长的一根最短是多少?
输入格式
输入的第一行包含两个整数n，m，用一个空格分隔。第二行包含n个正整数 L1，L2，…, Ln，依次表示每根木棍的长度。
输出格式
输出一行包含一个整数表示答案。
 */