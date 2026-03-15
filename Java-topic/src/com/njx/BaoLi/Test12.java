package com.njx.BaoLi;

import java.util.*;

public class Test12 {
    static long n;

    static long bestGcd = -1;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();

        // 1~8 数字
        int[] a = {1,2,3,4,5,6,7,8};

        // 枚举所有排列
        permute(a,0);

        System.out.println(ans);
    }

    // 全排列
    static void permute(int[] a,int start){

        if(start == 8){

            // 得到一个8位数
            String base = "";

            for(int x : a){
                base += x;
            }

            // 枚举插入位置
            for(int pos=0;pos<=8;pos++){

                // 插入数字1~8
                for(int d=1;d<=8;d++){

                    String s =
                            base.substring(0,pos)
                                    + d
                                    + base.substring(pos);

                    long num = Long.parseLong(s);

                    long g = gcd(num,n);

                    // 更新最大gcd
                    if(g > bestGcd){

                        bestGcd = g;
                        ans = num;

                    }else if(g == bestGcd){

                        ans = Math.min(ans,num);
                    }
                }
            }

            return;
        }

        // 交换生成排列
        for(int i=start;i<8;i++){

            swap(a,start,i);

            permute(a,start+1);

            swap(a,start,i);
        }
    }

    // 交换
    static void swap(int[] a,int i,int j){

        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 欧几里得算法求GCD
    static long gcd(long a,long b){

        while(b != 0){

            long t = a % b;

            a = b;
            b = t;
        }

        return a;

    }
}
/*
蓝桥小镇披萨店的老板刚刚烤制了他人生中的第个披萨！为了庆祝这一重要时刻，他推出了一项名为“幸运订单”的活动，顾客有机会赢取免费披萨。以下是活动的具体规则：
1.生成订单编号：每位顾客需要生成一个九位数的订单编号。生成方法如下：首先，将数字1到8 进行任意排列(每个数字正好出现一次)，组成一个八位数。然后，在这个八位数的任意位置（可以是开头、结尾或中间）插入一个1 到8的数字，从而得到一个九位数的订单编号。
2.计算最大公约数，赢取免费披萨：披萨店老板会计算每位顾客生成的订单编号与 的最大公约数（GCD）。如果某个订单编号与的最大公约数最大，那么该顾客就有机会赢得免费披萨。注意：订单编号必须严格满足上述生成规则，如果有多个订单编号与n的最大公约数相同且达到最大值，则只有生成数值最小的订单编号的顾客能够获奖。
现在，小蓝也想参加这个活动，并希望赢取免费披萨。请你帮助小蓝找出能够让他赢得免费披萨的订单编号。
输入格式
输入一行包含一个八位的正整数，表示披萨店老板烤制的第 n个披萨。
输出格式
输出一行包含一个九位的正整数表示答案，即小蓝能够赢得免费披萨的最小订单编号。
 */