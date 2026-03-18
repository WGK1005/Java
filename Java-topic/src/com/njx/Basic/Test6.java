package com.njx.Basic;

import java.util.*;

public class Test6 {
    static long getSum(long n) {

        if (n <= 0) return 0;

        long left = 1, right = (long)2e9;
        long k = 0;

        // 二分查找最大的k满足 k(k+1)/2 <= n
        while (left <= right) {
            long mid = (left + right) / 2;
            long len = mid * (mid + 1) / 2;

            if (len <= n) {
                k = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 前k组的长度
        long len = k * (k + 1) / 2;

        // 前k组的总和
        long sum = k * (k + 1) * (k + 2) / 6;

        // 剩余部分
        long remain = n - len;

        sum += remain * (remain + 1) / 2;

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            long l = sc.nextLong();
            long r = sc.nextLong();

            long ans = getSum(r) - getSum(l - 1);

            System.out.println(ans);
        }
    }
}
/*
小蓝发现了一个有趣的数列，这个数列的前几项如下：
1,1,2,1,2,3,1,2,3,4,··.
小蓝发现，这个数列前1 项是整数1，接下来 2 项是整数1 至 2，接下来 3 项是整数 1至 3，接下来 4 项是整数1至 4，依次类推。
小蓝想知道，这个数列中，连续一段的和是多少。
输入描述
输入的第一行包含一个整数T，表示询问的个数。
接下来T行，每行包含一组询问，其中第行包含两个整数l和 r，表示询问数列中第 l 个数到第 r 个数的和。
输出描述
输出T行，每行包含一个整数表示对应询问的答案。
 */