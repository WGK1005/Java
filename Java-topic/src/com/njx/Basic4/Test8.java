package com.njx.Basic4;

import java.util.*;
import java.io.*;

public class Test8 {
    static int INF = Integer.MAX_VALUE;
    static int mod = 1000000007 ;
    static int N = 1001000,M = 2*N;
    static int[] dp = new int[N],st = new int[N];
    static int n,m;
    static long ans;
    //递推思想，如果x删了一个数位后的那个数，能通过若干次删除得到一个质数，那么x就是一个质数

    //去除idx位置的值后的新数
    static int solve(char[] s,int idx){
        int res = 0;
        for(int i=0;i<s.length;i++){
            if(idx!=i){
                res = res * 10 + (s[i]-'0');
            }
        }

        return res;
    }


    public static void main(String[] args) throws IOException {
        n = 1000000;
        for(int i=2;i<=n;i++){
            if(st[i]==0){
                dp[i] = 1;
                if((long) i*i > n) continue;
                for(int j=i*i;j<=n;j+=i)
                    st[j] = 1;
            }
        }
        for(int i=1;i<=n;i++){
            char[] s = Integer.toString(i).toCharArray();
            for(int j=0;j<s.length;j++){
                int val = solve(s,j);
                // System.out.println(i+" "+val);
                dp[i] |= dp[val];
            }
            if(dp[i]==1) ans += 1;
            //   System.out.println(i+" "+dp[i]);
        }
        System.out.println(ans);

    }

    static Scanner sc = new Scanner(System.in);

}
/*
对于一个含有M个数位的正整数N，任意选中其中K个不同的数位（O≤ K<M），将这些选中的数位删除之后，余下的数位按照原来的顺序组成了一个新的数字P。如果至少存在一个 P是质数，我们就称 N 是一个× 质数。例如，对于整数7869，我们可以删去7和6，得到一个新的数字89，由于89 是一个质数，因此7869 是一个×质数。又如，对于整数 77，可以删去一个 7 后变为质数 7，因此77 也是一个×质数。
请问1（含）至1000000（含）中一共有多少个不同的×质数。对于一个含有M个数位的正整数N，任意选中其中K个不同的数位（O≤ K<M），将这些选中的数位删除之后，余下的数位按照原来的顺序组成了一个新的数字P。如果至少存在一个 P是质数，我们就称 N 是一个× 质数。例如，对于整数7869，我们可以删去7和6，得到一个新的数字89，由于89 是一个质数，因此7869 是一个×质数。又如，对于整数 77，可以删去一个 7 后变为质数 7，因此77 也是一个×质数。
请问1（含）至1000000（含）中一共有多少个不同的×质数。
 */