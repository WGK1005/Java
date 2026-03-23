package com.njx.Basic2;

import java.util.*;
//这道题感觉怎么改都不对，想不到更好得答案了
public class Test10 {
    static class Bomb {
        int p, l, r;
        Bomb(int p, int l, int r) {
            this.p = p;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bomb[] bombs = new Bomb[n];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            bombs[i] = new Bomb(p, l, r);
        }

        // 按位置排序
        Arrays.sort(bombs, (a, b) -> Integer.compare(a.p, b.p));

        // 初始化第一个炸弹主动引爆
        int ans = 1;
        long left = bombs[0].p - bombs[0].l;
        long right = bombs[0].p + bombs[0].r;

        for (int i = 1; i < n; i++) {
            long p = bombs[i].p;
            if (p <= right) {
                // 可以被当前引爆范围覆盖，扩大右边界
                right = Math.max(right, bombs[i].p + bombs[i].r);
            } else {
                // 无法覆盖，必须主动引爆
                ans++;
                left = bombs[i].p - bombs[i].l;
                right = bombs[i].p + bombs[i].r;
            }
        }

        System.out.println(ans);
    }
}
/*
小蓝在数轴上放置了 n 枚炸弹，第 枚炸弹的位置为 pi，其爆炸范围为[p－l,P 十 r]。当一枚炸弹爆炸时，其范围内的所有其他未爆炸的炸弹均会被引爆。小蓝希望知道至少需要主动引爆多少枚炸弹，才能使得所有炸弹都爆炸。
输入格式
输入的第一行包含一个正整数n。
接下来  行，每行包含三个整数 p,l,r，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */