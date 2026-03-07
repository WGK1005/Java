package com.njx.TanXin;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        long []A=new long[n];
        long []B=new long[n];
        long []C=new long[n];

        for(int i=0;i<n;i++){
            A[i]=sc.nextLong();
        }
        for(int i=0;i<n;i++){
            B[i]=sc.nextLong();
        }
        for(int i=0;i<n;i++){
            C[i]=sc.nextLong();
        }

        long[] d1 = new long[n];
        long[] d2 = new long[n];
        long[] d3 = new long[n];

        for(int i=0;i<n;i++){
            d1[i]=A[i]-B[i]-C[i];  // 魏国获胜：X > Y + Z
            d2[i]=B[i]-A[i]-C[i];  // 蜀国获胜：Y > X + Z
            d3[i]=C[i]-A[i]-B[i];  // 吴国获胜：Z > X + Y
        }
        int ans = Math.max(
                solve(d1),
                Math.max(solve(d2), solve(d3))
        );

        System.out.println(ans);
    }
    static int solve(long[] d){
        Arrays.sort(d);   // 从小到大

        long sum = 0;
        int cnt = 0;

        // 从最大开始选
        for(int i = d.length - 1; i >= 0; i--){
            sum += d[i];
            cnt++;

            if(sum > 0){
                return cnt;
            }
        }

        return -1;
    }
}
/*
小蓝正在玩一款游戏。游戏中魏(X)、蜀(Y)、吴(Z)三个国家各自拥有一定数量的士兵X，Y，Z（一开始可以认为都为 0）。游戏有个可能会发生的事件，每个事件之间相互独立且最多只会发生一次，当第个事件发生时会分别让 X，Y，Z增加Ai, Bi, Ci.
当游戏结束时（所有事件的发生与否已经确定），如果X，Y，Z 的其中一个大于另外两个之和，我们认为其获胜。例如，当 X >Y + Z 时，我们认为魏国获胜。小蓝想知道游戏结束时如果有其中一个国家获胜，最多发生了多少个事件?如果不存在任何能让某国获胜的情况，请输出一1。
输入格式
输入的第一行包含一个整数n。
第二行包含 n个整数表示 A，相邻整数之间使用一个空格分隔。
第三行包含n个整数表示B，相邻整数之间使用一个空格分隔。
第四行包含个整数表示 C，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */