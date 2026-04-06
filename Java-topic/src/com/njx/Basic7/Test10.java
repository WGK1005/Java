package com.njx.Basic7;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch - '0') % 2 == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
给定一个仅包含数字字符的字符串，请统计一下这个字符串中出现了多少个值为奇数的数位。
输入格式
输入一行包含一个字符串，仅由数字字符组成。
输出格式
输出一行包含一个整数，表示答案。
 */