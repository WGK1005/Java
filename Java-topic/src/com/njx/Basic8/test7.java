package com.njx.Basic8;

import java.util.*;

public class test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int times[] = new int[1001];
        for(int i = 0;i<L;i++) {
            times[sc.nextInt()/N] += 1;
        }
        int result = 0;
        for(int i = 0 ;i<1001/N+1;i++) {
            result += Math.min(M, times[i]);
        }
        System.out.print(result);
        sc.close();
    }
}
/*
小蓝最近为自己的服务开发了一套OpenAPI，为了防止接口被恶意盗刷，他需要搭建一套分布式限流组件。
简而言之，我们想要限制在时间区间[k·N，(k+1）·N)(k=0，1，2，··.）中，接口最多只允许成功访问M次，
对于超出限制的访问则返回异常状态表示请求失败。现在给出某个客户端对API 请求的时间戳，请你统计下其中有多少次的请求是成功的。
输入格式
输入的第一行包含三个整数N，M，L，相邻整数之间使用一个空格分隔。第二行包含 L 个整数t1，t2，·，tL，相邻整数之间使用一个空格分隔，表示L次API访问的时间戳。
输出格式
输出一行包含一个整数表示API请求成功的次数。
 */