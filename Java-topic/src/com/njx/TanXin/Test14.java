package com.njx.TanXin;

import java.util.*;
//通过率只有55，已经是我能想到的的最优解法了。但是codex写出了全过的代码
//codex的代码。
public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong();
        int k = sc.nextInt(); // 1-based
        long[] a = new long[n];

        long maxA = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            if (a[i] > maxA) maxA = a[i];
        }

        long ak = a[k - 1];

        List<Long> costs = new ArrayList<>();
        int unavoidableAhead = 0;

        for (int i = 0; i < n; i++) {
            if (i == k - 1) continue;

            boolean aheadNow = (a[i] > ak) || (a[i] == ak && i < k - 1);
            if (!aheadNow) continue;

            // 该人若是全场最大值，无法被降低
            if (a[i] == maxA) {
                unavoidableAhead++;
                continue;
            }

            long need;
            if (i < k - 1) {
                // 左侧同值也会压过小蓝，必须降到 <= ak - 1
                need = a[i] - ak + 1;
            } else {
                // 右侧只需降到 <= ak
                need = a[i] - ak;
            }

            // need 一定 >= 1（因为 aheadNow）
            costs.add(need);
        }

        Collections.sort(costs);

        int removed = 0;
        for (long c : costs) {
            if (m >= c) {
                m -= c;
                removed++;
            } else {
                break;
            }
        }

        int remainAhead = unavoidableAhead + (costs.size() - removed);
        System.out.println(remainAhead + 1); // 小蓝名次
    }
    }


    //我的代码
/*public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long ak = a[k - 1]; // 小蓝战力

        List<Long> diff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == k - 1) continue;

            if (a[i] > ak) {
                diff.add(a[i] - ak);
            }
        }

        Collections.sort(diff);
        int remain = diff.size(); // 初始比小蓝强的人数

        for (long d : diff) {

            if (m >= d) {
                m -= d;   // 消耗场次
                remain--; // 这个人已经不比小蓝强
            } else {
                break;
            }
        }

        // 小蓝排名 = 前面的人 + 1
        System.out.println(remain + 1);
    }
}
/*
小蓝所在宗门准备进行宗门大比，共有 n 名弟子参与，从左到右站成一排。第名弟子的功力值为α，小蓝是第k 名弟子。宗门大比将举行 m 次切磋，每次切由两名弟子进行，其中功力值高的弟子将获胜，功力值低的弟子的功力值将减 1。如果切磋的两名弟子功力值相同则平局，切后两名弟子的功力值保持不变。同一名弟子可能参与多次切磋，也可能一次都不参与。一名弟子可以和多名弟子切磋，两人也可以进行多次切。
切结束后，弟子们将按照功力值从高到低的顺序进入藏宝阁进行功法挑选，功力值相同的弟子按初始站位靠左的优先。小蓝想知道，如果他能规定每次切的人选，他在最优情况下能第几个进入藏宝阁？
输入格式
输入的第一行包含三个正整数 n,m,k，相邻整数之间使用一个空格分隔。
第二行包含 n 个正整数α1,α2,···，αn，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */