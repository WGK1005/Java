package com.njx.TanXin;

import java.util.*;

public class Test5 {
    static class Node{
        int ts;
        int id;
        public Node(int ts,int id){
            this.ts = ts;
            this.id = id;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int K = sc.nextInt();

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            int ts = sc.nextInt();
            int id = sc.nextInt();
            nodes[i] = new Node(ts,id);
        }
        //排序
        Arrays.sort(nodes, (a,b) -> {
            if (a.ts != b.ts) {
                return a.ts - b.ts;  // 时间戳不同，按时间戳排序
            }
            return b.id - a.id;      // 时间戳相同，按 id 降序排序
        });

        //存储结果
        TreeSet<Integer> set = new TreeSet<>();
        int l=0;
        for (int r = 0; r < N; r++) {
            if(nodes[ r].id!=nodes[l].id){
                l=r;
            }
            //收缩窗口
            while (nodes[r].ts - nodes[l].ts >= D || nodes[r].id != nodes[l].id) {
                l++;
            }
            //点赞数
            int cnt = r - l + 1;
            if (cnt >= K) {
                set.add(nodes[l].id);
            }

        }

        for (int id : set) {
            System.out.println(id);
        }
    }
}
/*
小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有 N 行。其中每一行的格式是：
ts id
表示在 ts 时刻编号 id 的帖子收到一个"赞"。
现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为 D 的时间段内收到不少于 K 个赞，小明就认为这个帖子曾是"热帖"。
具体来说，如果存在某个时刻 T 满足该帖在[T,T + D) 这段时间内(注意是左闭右开区间)收到不少于 K 个赞，该帖就曾是"热帖"。
给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
输入描述
输入格式：
第一行包含三个整数N，D,K。
以下 N 行每行一条日志，包含两个整数 ts 和 id。
其中, 1≤K≤N≤ 10,0≤ ts≤ 105,0≤d≤ 105.
输出描述
按从小到大的顺序输出热帖 id。每个 id 一行。
 */