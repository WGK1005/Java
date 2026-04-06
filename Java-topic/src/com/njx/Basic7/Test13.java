package com.njx.Basic7;

import java.util.*;

public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入：n表示数组a的大小，L表示秘境出口位置（环的长度）
        int n = sc.nextInt();
        int L = sc.nextInt();

        // 读取数组a，包含n个正整数
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        // 计算所有可能的步长：从数组a中任选两个数相加后对L取模
        HashSet<Integer> steps = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                steps.add((a[i] + a[j]) % L);
            }
        }

        // 使用BFS求从位置1到位置L的最短路径（最少瞬移次数）
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[L]; // dist[i]表示从位置1到达位置i+1的最少步数
        Arrays.fill(dist, -1);   // 初始化为-1，表示未访问过

        q.offer(0); // 起始位置为1，映射为索引0
        dist[0] = 0; // 起点距离为0

        // BFS遍历所有可达位置
        while (!q.isEmpty()) {
            int cur = q.poll(); // 取出当前节点

            // 尝试所有可能的步长
            for (int d : steps) {
                int next = (cur + d) % L; // 计算下一个位置

                // 如果该位置未被访问过
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1; // 更新距离
                    q.offer(next);              // 加入队列继续搜索
                }
            }
        }

        // 输出到达位置L（映射为索引L-1）的最少步数，若不可达则输出-1
        System.out.println(dist[L - 1]);
    }
}
/*
小蓝在环游宇宙的过程中误入了一个数轴上的秘境，秘境的入口为1，这是小蓝的初始位置，出口为L，小蓝每次可以选取两个正整数 x, y ，
其中 x, y ∈ {a1， a2，···， an}，并向右瞬间移动x十y的距离，然而，秘境有大小限制，如果小蓝当前位置为p，
则瞬移后的位置为(p+x十 y-1）modL+1，当小蓝的位置在出口L时即可离开秘境，请问小蓝最少瞬移多少次之后可以离开秘境?
输入格式
输入的第一行包含两个正整数n，L，用一个空格分隔。第二行包含n个整数a1，a2，··，an，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案，如果小蓝永远无法离开秘境，输出一1。
 */