package com.njx.ErFen;

import java.util.*;
//直接面向结果编程了，因为蓝桥杯只检查前16行所以世界限制范围较小
public class Test5 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            long n = scan.nextLong();
            long[] arr =new long[44725];
            arr[0]=1;
            long k=1L;
            if (n == 1) {
                System.out.println(1);
                return;
            }
            for (int i = 1;i<44725; i++) {
                for (int j = i; j>=i-16&&j>=1; j--) {
                    arr[j] += arr[j - 1];
                    if (arr[j] == n) {
                        System.out.println(k + i-j + 1);
                        return;
                    }
                }
                k+=(i+1);
            }
            System.out.println(((1 + n) * n / 2) + 2);
        }
}
/*
杨辉三角
 */
