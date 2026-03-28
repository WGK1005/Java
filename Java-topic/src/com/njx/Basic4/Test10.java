package com.njx.Basic4;

import java.util.*;
import java.io.*;

public class Test10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }

        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for (int i = 0; i <= n; i++) {
            long cur = (i == n) ? 0 : a[i];

            while (!stack.isEmpty() && a[stack.peek()] > cur) {
                int idx = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long width = right - left - 1;
                long area = a[idx] * width;

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        System.out.println(max);
    }
}
/*
给定—个长度为n的序列Ai，求L， R使(R一L +1）.min(AL， AL+1，·，AR) 尽可能大，其中min 表示最小值。
你只需要输出最大的值即可，不需要输出具体的L，R。
输入格式
输入的第一行包含一个整数n。
第二行包含n个整数，分别表示A1，A2，···，An，相邻两个整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */