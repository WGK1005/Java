package com.njx.DP;

import java.util.*;
//感觉dp太难了，这只是难度为易的题。。。
public class Test3 {

    // n 行 m 列
    static int n, m;

    // t[i][j] 表示格子 (i,j) 的染色时间
    static int[][] t;

    // dist[i][j] 表示格子 (i,j) 被触发染色的最早时间
    static long[][] dist;

    // 四个方向：下 上 右 左
    static int[][] dir = {
            {1,0},   // 向下
            {-1,0},  // 向上
            {0,1},   // 向右
            {0,-1}   // 向左
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 输入棋盘大小
        n = sc.nextInt();
        m = sc.nextInt();

        // 初始化数组
        t = new int[n][m];
        dist = new long[n][m];

        // 读取每个格子的染色时间
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                t[i][j] = sc.nextInt();

                // 初始化为最大值
                // 表示目前还没有被触发
                dist[i][j] = Long.MAX_VALUE;
            }
        }

        /*
        优先队列（小根堆）
        用来每次取出当前触发时间最小的格子

        long[] 存三个信息：
        [0] 当前触发时间
        [1] 行坐标
        [2] 列坐标
        */
        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a->a[0]));

        // 起点 (0,0) 在时间0被触发
        dist[0][0] = 0;

        // 加入优先队列
        pq.offer(new long[]{0,0,0});

        // Dijkstra 主循环
        while(!pq.isEmpty()){

            // 取出当前触发时间最早的格子
            long[] cur = pq.poll();

            long time = cur[0];  // 当前触发时间
            int x = (int)cur[1]; // 当前行
            int y = (int)cur[2]; // 当前列

            /*
            如果当前时间大于已经记录的最优时间
            说明这是旧数据，直接跳过
            */
            if(time > dist[x][y]) continue;

            // 遍历四个方向
            for(int[] d : dir){

                int nx = x + d[0]; // 新行
                int ny = y + d[1]; // 新列

                // 判断是否越界
                if(nx>=0 && nx<n && ny>=0 && ny<m){

                    /*
                    传播时间计算：

                    当前格子在 time 时刻被触发
                    它需要 t[x][y] 秒变成彩色
                    然后才触发邻居

                    所以邻居被触发的时间是：
                    */
                    long nt = time + t[x][y];

                    /*
                    如果发现更早的触发时间
                    就更新
                    */
                    if(nt < dist[nx][ny]){
                        dist[nx][ny] = nt;

                        // 加入队列继续扩散
                        pq.offer(new long[]{nt,nx,ny});
                    }
                }
            }
        }

        /*
        现在 dist[i][j] 是格子被触发的时间
        但它真正变成彩色还需要 t[i][j] 秒

        所以完成时间是：
        dist[i][j] + t[i][j]
        */

        long ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                // 找到最后完成染色的格子
                ans = Math.max(ans, dist[i][j] + t[i][j]);

            }
        }

        // 输出整个棋盘完成染色的时间
        System.out.println(ans);
    }
}
/*
小蓝有一个 n 行 m 列的白色棋盘,棋盘的每一个方格都可以被染成彩色。
每个方格有一个染色时间tu，不同方格的染色时间可能不同。如果一个方格被触发了染色，这个方格就会在tu秒之后变成彩色，然后将自己上下左右四个方向相邻的方格触发染色。每个方格只能被触发染色一次，第一次触发之后的触发为无效触发。
给定每个方格的染色时间，在时刻0触发第一行第一列的方格染色，请问多长时间后整个棋盘完成染色。
输入格式
输入的第一行包含两个整数n，m，分别表示棋盘的行数和列数。接下来n行，每行 m 个正整数，相邻的整数之间用一个空格分隔,表示每个方格的染色时间。该部分的第行第 个整数表示 tj，即第行第} 列的方格的染色时间。
输出格式
输出一行包含一个整数，表示整个棋盘完成染色的时间。
 */