package com.njx.Basic7;

import java.util.*;

public class Test7 {
    // 邻接表边结构：to 为目标点，w 为边权
    static class Edge {
        int to;
        long w;
        Edge(int t, long w) {
            this.to = t;
            this.w = w;
        }
    }

    static int n;
    static List<Edge>[] g;
    // 全局最优解：满足条件的 3 条边最大权值和
    static long ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        // 输入是一棵树：i(>=2) 与 x 之间有一条长度为 y 的无向边
        for (int i = 2; i <= n; i++) {
            int x = sc.nextInt();
            long y = sc.nextLong();
            g[i].add(new Edge(x, y));
            g[x].add(new Edge(i, y));
        }

        // 以 1 为根做一次 DFS，过程中更新全局答案
        dfs(1, 0);

        System.out.println(ans);
    }

    // 返回：从 u 出发向其子树延伸的一条最大链长（不走回 parent）
    static long dfs(int u, int parent) {

        // 记录“经过某个子节点继续向下”形成的链长
        List<Long> list = new ArrayList<>();

        for (Edge e : g[u]) {
            if (e.to == parent) continue;

            long val = dfs(e.to, u) + e.w;
            list.add(val);
        }

        // 大到小排序，便于取前几大
        list.sort((a, b) -> Long.compare(b, a));

        // 形态1：三条边在一条主干上（经过 u 汇合三段贡献）
        if (list.size() >= 3) {
            ans = Math.max(ans, list.get(0) + list.get(1) + list.get(2));
        }

        // 形态2：Y 型，直接取与 u 相连的三条最大边
        if (g[u].size() >= 3) {
            List<Long> edges = new ArrayList<>();
            for (Edge e : g[u]) {
                edges.add(e.w);
            }
            edges.sort((a, b) -> Long.compare(b, a));
            ans = Math.max(ans, edges.get(0) + edges.get(1) + edges.get(2));
        }

        // 向父节点返回“从 u 往下能提供的最大单链贡献”
        return list.isEmpty() ? 0 : list.get(0);
    }
}
/*
给定一棵包含n个结点的树，找出 3条边使得这三条边的端点仅经过这三条边即可互相到达且三条边的长度和尽可能大。
输入格式
输入第一行包含一个整数n 表示树的结点数。
接下来n一1行，每行包含两个整数，用一个空格分隔。其中第i行的两个数xi，Yi，表示编号为i+1和xi的结点之间有一条长度为yi的边。
输出格式
输出一行，包含一个整数表示满足要求的三条边的长度之和的最大值。
 */