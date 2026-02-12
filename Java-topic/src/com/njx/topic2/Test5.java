package com.njx.topic2;

import java.util.*;
//小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到 40 中
// 这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
//请问，在 1 到n中，所有这样的数的和是多少？
public class Test5 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long sum = 0;
            for (int i = 1; i <= n; i++) {
                if (cheak(i)) {
                    sum += i;
                }
            }
            System.out.println(sum);
            sc.close();
        }

        private static boolean cheak(int n) {
            while (n != 0) {
                int a = n % 10;
                if (a == 2 || a == 0 || a == 1 || a == 9) {
                    return true;
                }
                n /= 10;
            }
            return false;
        }
    }
//感觉没什么，以这道题的难度就是暴力枚举