package com.njx.Basic8;

import java.util.*;

public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            for (int i = 0; i < n; i++) {
                a[i] *= Integer.bitCount(a[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
/*
输入一个数组a，包含有n个元素a1，a2，·，an。对这个数组进行m次变换，每次变换会将数组a中的每个元素αi转换为 ai·bitCount(ai)。
其中 bitCount(x)表示数字x的二进制表示中1出现的次数，例如bitCount(3）=2，因为3的二进制表示为11，其中1出现了两次。请输出变换之后的数组内容。
输入格式
输入的第一行包含一个正整数n，表示数组 α中的元素个数。
第二行包含n个整数a1，a2，··，an，相邻整数之间使用一个空格分隔。
第三行包含一个整数m，表示变换次数。
输出格式
输出一行，包含n个整数，相邻整数之间使用一个空格分隔，表示变换之后得到的数组α。
 */