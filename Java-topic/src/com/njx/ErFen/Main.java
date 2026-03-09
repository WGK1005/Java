package com.njx.ErFen;

import java.util.*;

public class Main {
    static int n;
    static double[] a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new double[n];
        b = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        double left = 0;
        double right = 10000;

        // 二分答案，迭代100次精度足够
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        double ans = right;

        // 输出：整数就输出整数，否则保留一位小数
        if (Math.abs(ans - Math.round(ans)) < 1e-6) {
            System.out.println(Math.round(ans));
        } else {
            System.out.printf("%.1f%n", ans);
        }
    }

    static boolean check(double d) {
        // seg[i] = {最左起点, 最右起点, 区间长度}
        double[][] seg = new double[n][3];

        for (int i = 0; i < n; i++) {
            double len = b[i] - a[i];
            seg[i][0] = a[i] - d; // 最左起点（位移 -d）
            seg[i][1] = a[i] + d; // 最右起点（位移 +d）
            seg[i][2] = len;      // 区间长度不变
        }

        // 按最左起点排序（等价于按原始起点排序）
        Arrays.sort(seg, Comparator.comparingDouble(x -> x[0]));

        double cur = 0; // 当前已覆盖到的右端点，初始需覆盖从 0 开始

        for (int i = 0; i < n; i++) {
            double L = seg[i][0]; // 该区间最左能放的位置
            double R = seg[i][1]; // 该区间最右能放的位置
            double len = seg[i][2];

            // 该区间即使尽量靠左放，也无法覆盖到 cur（存在空隙）
            if (L > cur) return false;

            // 贪心：起点尽量靠右延伸覆盖，但不能超过 R
            double start = Math.min(cur, R);

            // 更新覆盖右端（取 max 防止 cur 倒退）
            cur = Math.max(cur, start + len);

            if (cur >= 10000) return true;
        }

        return cur >= 10000;
    }
}


