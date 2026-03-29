package com.njx.Basic5;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //反向遍历
        for(int i = 10000000 ; i > 0 ; i--){
            if(check(i)){// i为目标则打印结果，并结束循环
                System.out.println(i);
                break;
            }
        }
        scan.close();
    }

    /**
     *检查该数是否为类斐波那契循环数
     */
    public static boolean check(int x){
        String s = x + "";
        // 获取位数
        int l = s.length();
        int[] dp = new int[l];
        // 数x的每一位都拆出来存入数组
        for(int i = 0 ; i < l ; i++){
            dp[i] = s.charAt(i) - '0';
        }
        int sum = 0 ;
        // 迭代数组检查该数是否为类斐波那契循环数
        for(int i = l ; sum < x ; i++){
            sum = Arrays.stream(dp).sum();// 数组求和
            dp[i%l] = sum;
        }
        // 跳出循环后sum >= x
        return sum == x;
    }
}
/*
对于一个有n位的十进制数N = d₁d2d3· .dn，可以生成一个类斐波那契数列S，数列S的前n个数为：
{S1 = d1, S2 = d2, S3 = d3, · · · , Sn = dn }
数列S的第k(k>n)个数为：
k−1
S
i=k−n
如果这个数N会出现在对应的类斐波那契数列S中，那么N就是一个类斐波那契循环数。
例如对于197，对应的数列S为：
{1,9, 7,17, 33,57,107,197,...}
197出现在S中，所以197是一个类斐波那契循环数。请问在0至10⁷中，最大的类斐波那契循环数是多少？
 */