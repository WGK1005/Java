package com.njx.topic2;
import java.util.*;

//Fibonacci 数列是非常著名的数列:
//F[1] = 1,
//F[2] = 1,
//对于i > 3, F[i] = F[i-1] + F[i-2]。
//Fibonacci数列有一个特殊的性质，前一项与后一项的比值，F[N] / F[N + 1]， 会趋近于黄金分割。
//为了验证这一性质，给定正整数 N，请你计算 F[N] /F[N +1]，并保留 8 位小数。
//输入描述
//输入—个正整数 N (1 ≤ N ≤ 2 × 10°)。
//输出描述
//输出 F[N] / F[N + 1]。答案保留 8 位小数。
public class Test6 {
    public   static int fib(int n){
        if(n == 1 || n == 2)
            return 1;
        else
            return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%.8f",(double)fib(n)/fib(n+1));
    }
}
//也很简单..
//烂题。涉及到fib的运算爆炸，所以在20 项后就直接输出0.618.。。