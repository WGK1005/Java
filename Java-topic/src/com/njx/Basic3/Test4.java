package com.njx.Basic3;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
        }
        System.out.println(result);
    }
}
/*
题目描述
在数列 a1,α2,···,an 中，如果a < ai+1 < αi+2 <···< j，则称 α; 至α; 为一段递增序列，长度为 j 一i+1.
定一个数列，请问数列中最长的递增序列有多长。
输入描述
输入的第一行包含一个整数n。
第二行包含n 个整数α1,α2,···，αn，相邻的整数间用空格分隔，表示给定的数列。
其中，2≤n≤ 1000，0≤数列中的数≤104。
输出描述：
输出一行包含一个整数，表示答案。
 */
