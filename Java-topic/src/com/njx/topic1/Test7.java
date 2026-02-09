package com.njx.topic1;

import java.util.*;


public class Test7 {
    public static void main(String[] args) {
        //冰雹数
        //任意给定一个正整数N
        //如果是偶数，执行：N/2
        //如果是奇数，执行：N×3+1
        //生成的新的数字再执行同样的动作，循环往复。
        //通过观察发现，这个数字会一会儿上升到很高，一会儿又降落下来。
        //就这样起起落落的，但最终必会落到"1"，这有点像小冰雹粒子在冰雹云中翻滚增长的样子。
        //比如N=9
        //9,28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1
        //可以看到，N=9的时候，这个"小冰雹"最高冲到了52这个高度。

        //scanner用法
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //System.out.println(n);
        //sc.close();
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Set<Long> set = new HashSet<>();
        //输入一个N
        int N = scan.nextInt();
        //对N进行处理，从不大于N的奇数开始
        int n = N % 2 == 0 ? N - 1 : N;
        //max存储能到达的最大值
        long max = N;
        //temp存储每次寻找的中间数
        long temp;
        //循环i的范围是[n,1)之间的奇数
        for (int i = n; i > 1; i -= 2) {
            //如果set里已经有i了，说明之前寻找过程中已经出现i,不必再寻找了
            if (set.contains((long) i)) continue;

            temp = i;
            //寻找过程...
            while (temp != 1 && !set.contains(temp)) {
                set.add((temp));//对当前的temp,存进set
                if (temp % 2 == 1) {
                    temp = temp * 3 + 1;
                }
                max = Math.max(max, temp);
                while (temp % 2 == 0) {
                    temp /= 2;
                }
            }
        }

        System.out.println(max);
        scan.close();
    }
}

