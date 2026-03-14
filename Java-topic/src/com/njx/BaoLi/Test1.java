package com.njx.BaoLi;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans=0;
        while(n != 0){
          int sum = getSum(n);
            n -= sum;
            ans++;
        }
        System.out.println(ans);
    }
    public static int getSum(long x){
        int sum = 0;

        while(x > 0){
            sum += x % 10;  // 取最后一位
            x /= 10;        // 去掉最后一位
        }

        return sum;
    }
}
/*
小蓝有一个整数 。每分钟，小蓝的数都会发生变化，变为上一分钟的数减去上一分钟的数的各个数位和。
例如，如果小蓝开始时的数为 23，则下一分钟变为 23－(2 +
3)= 18，再下一分钟变为 18-(1+ 8)= 9，再下一分钟变为9-9 = 0，共经过了 3 分钟变为 0。
给定一个正整数，请问这个数多少分钟后变为0。
输入格式
输入一行包含一个整数n。
输出格式
输出一个整数，表示答案。
 */