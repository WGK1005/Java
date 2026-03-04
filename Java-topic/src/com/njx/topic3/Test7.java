package com.njx.topic3;

import java.util.*;
//没看明白，需要重新再看
public class Test7 {
    static int n, m;
    static List<Integer>[] graph; // 邻接表
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取节点数和边数
        n = sc.nextInt();
        m = sc.nextInt();

        // 初始化邻接表
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 读取所有边（无向图）
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        // 读取查询点
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 先判断 x 和 y 是否本来连通
        visited = new boolean[n + 1];
        dfs(x, -1);   // -1 表示不删除任何点

        if (!visited[y]) {
            System.out.println(-1);
            return;
        }

        int dangerCount = 0;

        // 枚举每一个点 z
        for (int z = 1; z <= n; z++) {

            // 不能删除 x 或 y
            if (z == x || z == y) continue;

            visited = new boolean[n + 1];

            // 删除 z
            dfs(x, z);

            // 如果删除 z 后 x 到不了 y
            if (!visited[y]) {
                dangerCount++;
            }
        }

        System.out.println(dangerCount);
    }

    /**
     * DFS遍历
     * @param current 当前访问节点
     * @param deleted 被删除的节点
     */
    public static void dfs(int current, int deleted) {

        // 如果当前节点是被删除的点，直接返回
        if (current == deleted) return;

        visited[current] = true;

        for (int next : graph[current]) {

            // 跳过已访问节点
            if (visited[next]) continue;

            // 跳过被删除节点
            if (next == deleted) continue;

            dfs(next, deleted);
        }
    }
}
/*我们来定义一个危险系数 DF(x,y):
对于两个站点和 y（x!= y),如果能找到一个站点，当 z被敌人破坏后， x和 y 不连通，那么我们称z为关于x,y 的关键点。相应的，对于任意一对站点  和 y，危险系数
DF(x,y）就表示为这两点之间的关键点个数。
本题的任务是：已知网络结构，求两站点之间的危险系数。
输入描述
输入数据第一行包含 2 个整数n(2 ≤n ≤1000),m(0 ≤m ≤ 2000),分别代表站点数，通道数;
接下来m 行, 每行两个整数u, (1 ≤u, ≤ n,u!=)代表一条通道;
最后1行，两个数u,，代表询问两点之间的危险系数DF(u,v).
输出描述
输出一个整数，如果询问的两点不连通则输出-1.
 */