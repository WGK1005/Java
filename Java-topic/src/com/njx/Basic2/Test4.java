package com.njx.Basic2;

import java.util.*;
import java.io.*;

public class Test4 {

    static boolean check(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                char c = s.charAt(r);

                // 必须能补这个字符
                if (c != 'l' && c != 'q' && c != 'b') {
                    return false;
                }

                // 模拟在前面补一个 s[r]
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {                    //while (T-- > 0) 是一个常见的循环控制语句，用于执行 T 次循环
            String s = br.readLine();

            if (check(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
/*
小蓝最近迷上了回文字符串，他有一个只包含小写字母的字符串S，小蓝可以往字符串S的开头处加入任意数目个指定字符：1、q、b（ASCII 码分别为：108、113、98）。小蓝想要知道他是否能通过这种方式把字符串S 转化为一个回文字符串。
输入格式
输入的第一行包含一个整数T，表示每次输入包含T组数据。
接下来依次描述T组数据。
V
每组数据一行包含一个字符串S。
输出格式
输出T行，每行包含一个字符串，依次表示每组数据的答案。如果可以将 S 转化为一个回文字符串输出 Yes，否则输出No。
 */