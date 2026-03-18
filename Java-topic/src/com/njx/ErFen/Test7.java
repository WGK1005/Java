package com.njx.ErFen;

import java.util.*;
//这道题本身是二分但是直接暴力也能，所以就直接用暴力了
public class Test7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();     // 数组长度
        long m = sc.nextLong();   // 可用的额外资源

        int[] a = new int[n];
        int[] b = new int[n];

        // 输入数组 a
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 输入数组 b
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int rounds = 0;   // 成功完成的轮数

        boolean canContinue = true;  // 是否还能继续

        // 不断进行“轮次”
        while (canContinue) {

            // 尝试完成一整轮
            for (int i = 0; i < n; i++) {

                // 优先消耗 a[i]
                if (a[i] > 0) {
                    a[i]--;
                }
                // 如果 a[i] 没了，用 b[i] + m
                else if (b[i] > 0 && m > 0) {
                    b[i]--;
                    m--;
                }
                // 两种都不行 → 本轮失败
                else {
                    canContinue = false;
                    break;
                }
            }

            // 如果这一轮完整做完 → 计数+1
            if (canContinue) {
                rounds++;
            }
        }

        System.out.println(rounds);

    }
}
/*

 */