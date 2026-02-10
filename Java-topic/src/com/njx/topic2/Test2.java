package com.njx.topic2;
import java.util.*;


public class Test2 {
    // 最大村庄数量（比 1000 稍大，防止越界）
    static final int MAXN = 1005;

    // 村庄数量
    static int n;

    // 分别存储每个村庄的 x 坐标、y 坐标、高度 h
    static double[] x = new double[MAXN];
    static double[] y = new double[MAXN];
    static double[] h = new double[MAXN];

    // dist[i] 表示：当前生成树连接到第 i 个村庄的最小费用
    static double[] dist = new double[MAXN];

    // vis[i] 表示：第 i 个村庄是否已经加入最小生成树
    static boolean[] vis = new boolean[MAXN];

    /**
     * 计算两个村庄 i 和 j 之间的连线费用
     *
     * 题目规定：
     *   坐标距离 = sqrt((xi-xj)^2 + (yi-yj)^2)
     *   高度代价 = (hi-hj)^2
     *   总费用   = 坐标距离 + 高度代价
     */
    static double cost(int i, int j) {
        double dx = x[i] - x[j];   // 横坐标差
        double dy = y[i] - y[j];   // 纵坐标差
        double dh = h[i] - h[j];   // 高度差
        return Math.sqrt(dx * dx + dy * dy) + dh * dh;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 读入村庄数量
        n = sc.nextInt();

        // 读入每个村庄的坐标和高度
        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
            h[i] = sc.nextDouble();

            // 初始化：所有点到生成树的距离为无穷大
            dist[i] = Double.MAX_VALUE;

            // 初始化：所有点都还没加入生成树
            vis[i] = false;
        }

        // ===== Prim 算法开始 =====

        // 从 1 号村庄开始（它是发电站）
        dist[1] = 0;

        // 最小生成树的总费用
        double ans = 0;

        // 一共要选 n 次，把 n 个村庄全部加入生成树
        for (int i = 1; i <= n; i++) {

            int u = -1;                 // 当前要选的村庄编号,占位，表明还没选择村庄
            double min = Double.MAX_VALUE;

            // 在所有「未加入生成树」的村庄中
            // 找 dist 最小的那个
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            // 将选中的村庄加入生成树
            vis[u] = true;

            // 累加费用
            ans += min;

            // 用新加入的村庄 u
            // 去更新其他未加入村庄的最小连接费用
            for (int v = 1; v <= n; v++) {
                if (!vis[v]) {
                    double c = cost(u, v);
                    // 如果通过 u 连接更便宜，就更新
                    if (c < dist[v]) {
                        dist[v] = c;
                    }
                }
            }
        }

        // 输出结果，保留两位小数（蓝桥杯常见要求）
        System.out.printf("%.2f\n", ans);
    }
}
