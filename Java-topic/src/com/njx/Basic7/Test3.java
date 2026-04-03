package com.njx.Basic7;

import java.util.*;
//很简单的思路但是效果不错，70的通过率很可以了
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        while (m-- > 0) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (op == 1) {
                for (int i = x; i <= y; i += 2) {
                    a[i] ^= 1;
                }
            } else if (op == 2) {
                for (int i = x; i <= y; i += 3) {
                    a[i] ^= 1;
                }
            } else if (op == 3) {
                for (int i = x; i <= y; i++) {
                    a[i] ^= 1;
                }
            } else {
                int ans = 0;
                for (int i = x; i <= y; i++) {
                    ans += a[i];
                }
                System.out.println(ans);
            }
        }
    }
}
/*
给定n个硬币的初始状态，以及 m次如下类型的操作：
1.1xy:将[x，y]之间的硬币每隔一个翻转一个，即翻转x, x + 2, x + 4, · · • , x + 2t (x + 2t ≤ y);
2.2xy:将x，y之间的硬币每隔两个翻转一个，即翻转x, x + 3, x + 6, · · · , x + 3t (x + 3t ≤ y);
3.3xy:将[x,y]之间的硬币全部翻转;
4.4xy:查询[x，y]之间正面朝上的硬币个数。
输入格式
输入的第一行包含两个正整数n，m，用一个空格分隔，分别表示硬币数和操作数。
第二行包含n个整数f1，f2，·，fn，相邻整数之间使用一个空格分隔，表示每个硬币的初始状态，其中 fi=0 表示第i个硬币为反面朝上，fi=1表示第i个硬币为正面朝上。
接下来m行，每行包含三个正整数ai，ai，yi，相邻整数之间使用一个空格分隔，表示一次操作。
输出格式
输出若干行。对于每次查询操作(4xy)，输出一行包含一个整数表示该查询的答案。
 */