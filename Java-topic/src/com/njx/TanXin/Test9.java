package com.njx.TanXin;

import java.util.*;

public class Test9 {
    static class Zhuan{
        int w;
        int v;

        public Zhuan(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Zhuan[] zhuan = new Zhuan[n];

        for (int i = 0; i < n; i++) {
            int w= sc.nextInt();
            int  v = sc.nextInt();
            zhuan[i] = new Zhuan(w, v);
        }
        Arrays.sort(zhuan, (x, y) -> (x.w + x.v) - (y.w + y.v));

        int maxweight = 0;
        for (int i = 0; i < n; i++) {
            maxweight += zhuan[i].w;
        }

        int[] dp = new int[maxweight + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int w = zhuan[i].w;
            int v = zhuan[i].v;
            for (int j = maxweight; j >= w; j--) {
                if (dp[j - w] != -1 && (j - w) <= v) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        int ans=0;
        for (int i = 0; i <= maxweight; i++) {
            if (dp[i]!=-1){
                ans=Math.max(ans,dp[i]);
            }
        }
        System.out.println(ans);

    }
}
/*
这天，小明在搬砖。
他一共有  块砖,他发现第  砖的重量为 w,价值为 。他突然想从这些砖中选一些出来从下到上堆成一座塔，并且对于塔中的每一块砖来说，它上面所有砖的重量和不能超过它自身的价值。
他想知道这样堆成的塔的总价值（即塔中所有砖块的价值和）最大是多少。
输入格式
输入共 n + 1 行,第一行为一个正整数 n,表示砖块的数量。
后面n行，每行两个正整数w,分别表示每块砖的重量和价值。
输出格式
一行，一个整数表示答案。
 */