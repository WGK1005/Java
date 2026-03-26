package com.njx.Basic3;

import java.util.*;

public class Test14 {
        static class Node {
            int x, y, step; // step 表示第几分钟

            Node(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            int t = sc.nextInt();

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];

            // 读入所有水管（多源 BFS 起点）
            for (int i = 0; i < t; i++) {
                int r = sc.nextInt() - 1; // 转成0-index
                int c = sc.nextInt() - 1;

                queue.offer(new Node(r, c, 0));
                visited[r][c] = true;
            }

            int k = sc.nextInt();

            // 四个方向
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int count = 0;

            // BFS
            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                // 超过k分钟，不扩展
                if (cur.step > k) continue;

                count++; // 当前格子被灌溉

                // 扩展四个方向
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    // 判断边界 + 是否访问过
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, cur.step + 1));
                    }
                }
            }

            System.out.println(count);
        }
    }
/*
小蓝负责花园的灌溉工作。
花园可以看成一个 n 行 m 列的方格图形。中间有一部分位置上安装有出水管。
小蓝可以控制一个按钮同时打开所有的出水管，打开时，有出水管的位置可以被认为已经灌溉好。
每经过一分钟，水就会向四面扩展一个方格，被扩展到的方格可以被认为已经灌溉好。即如果前一分钟某一个方格被灌溉好，则下一分钟它上下左右的四个方格也被灌溉好。
给定花园水管的位置，请问k分钟后，有多少个方格被灌溉好？
输入描述
输入的第一行包含两个整数n，m。
第二行包含一个整数t，表示出水管的数量。
接下来t行描述出水管的位置，其中第行包含两个数r,c表示第r 行第c列有一个排水管。
接下来一行包含一个整数k。
其中, 1 ≤n,m ≤ 100,1 ≤t≤ 10,1 ≤k ≤ 100.输出描述
输出一个整数，表示答案。
 */