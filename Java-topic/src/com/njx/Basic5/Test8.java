package com.njx.Basic5;

import java.util.*;
import java.io.*;


public class Test8 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] p = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            p[i] = new Point(x, y);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Long, List<Integer>> map = new HashMap<>();

            // 1. 计算距离并分组
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long dx = p[j].x - p[i].x;
                long dy = p[j].y - p[i].y;
                long dist = dx * dx + dy * dy;

                map.putIfAbsent(dist, new ArrayList<>());
                map.get(dist).add(j);
            }

            // 2. 枚举每个距离组
            for (List<Integer> list : map.values()) {
                int size = list.size();
                if (size < 2) continue;

                // 枚举两点
                for (int a = 0; a < size; a++) {
                    for (int b = a + 1; b < size; b++) {
                        int j = list.get(a);
                        int k = list.get(b);

                        // 判断是否共线（叉积）
                        long x1 = p[j].x - p[i].x;
                        long y1 = p[j].y - p[i].y;
                        long x2 = p[k].x - p[i].x;
                        long y2 = p[k].y - p[i].y;

                        if (x1 * y2 - x2 * y1 != 0) {
                            ans++;
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
/*
小明在二维坐标系中放置了n 个点，他想在其中选出一个包含三个点的子集，这三个点能组成三角形。
然而这样的方案太多了，他决定只选择那些可以组成等腰三角形的方案。请帮他计算出一共有多少种选法可以组成等腰三角形？
输入格式
输入共n+1行。
第一行为一个正整数n。
后面n行，每行两个整数xi，yi表示第i个点的坐标。
输出格式
输出共1行，一个整数。
 */