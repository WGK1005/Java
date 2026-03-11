package com.njx.TanXin;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        int cost = 0;
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int sum=a+b;
            cost += sum;
            pq.add(sum);
        }
        System.out.println(cost);
    }
}
/*
题目描述
在很久很久以前，有 n 个部落居住在平原上，依次编号为 1 到n。第个部落的人数为 t。
有一年发生了灾荒。年轻的政治家小蓝想要说服所有部落一同应对灾荒，他能通过谈判来说服部落进行联合。
每次谈判，小蓝只能邀请两个部落参加，花费的金币数量为两个部落的人数之和，谈判的效果是两个部落联合成一个部落（人数为原来两个部落的人数之和）。
输入描述
输入的第一行包含一个整数，表示部落的数量。
第二行包含n个正整数，依次表示每个部落的人数。
其中,1≤n≤ 1000,1≤t≤ 10。
输出描述
输出一个整数，表示最小花费。
 */