package com.njx.Basic8;

import java.util.*;

public class Test16 {
    static class Circle {
        long x;
        long y;
        long r;

        Circle(long x, long y, long r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static class Edge {
        int u;
        int v;
        double w;

        Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class DSU {
        int[] p;
        int[] sz;

        DSU(int n) {
            p = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                return false;
            }
            if (sz[ra] < sz[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }
            p[rb] = ra;
            sz[ra] += sz[rb];
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long r = sc.nextLong();
            circles[i] = new Circle(x, y, r);
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = circles[i].x - circles[j].x;
                double dy = circles[i].y - circles[j].y;
                double d = Math.sqrt(dx * dx + dy * dy);
                double gap = d - circles[i].r - circles[j].r;
                if (gap < 0) {
                    gap = 0;
                }
                edges.add(new Edge(i, j, gap));
            }
        }

        edges.sort(Comparator.comparingDouble(e -> e.w));
        DSU dsu = new DSU(n);
        double ans = 0;
        int used = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                ans += e.w;
                used++;
                if (used == n - 1) {
                    break;
                }
            }
        }

        System.out.printf("%.2f%n", ans);

    }
}
/*
小明正在参加一场爆破工作。人们在地面上放置了n个爆炸魔法阵，第i个魔法阵的圆心坐标为(xi，Yi），半径为ri。
如果两个魔法阵相交，则它们可以一起引爆；如果两个魔法阵不相交，则可以再使用一条魔法回路将它们的边缘连接起来。
小明想知道最少需要布置总长度多长的魔法回路才能使得所有的魔法阵可以一起引爆？
输入格式
输入共n+1行。
● 第一行为一个正整数n。
• 后面n行，每行三个整数表示 xi，Yi，ri。
输出格式
输出共1行，一个浮点数表示答案（四舍五入保留两位小数）。
 */