package com.njx.Basic;

import java.util.*;

public class Test17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            String prefix = s.substring(0, i);
            for (int j = 0; j < n; j++) {
                String suffix = s.substring(j);
                String combined = prefix + suffix;
                if (isPalindrome(combined)) {
                    maxLen = Math.max(maxLen, combined.length());
                }
            }
        }

        System.out.println(maxLen);
        sc.close();
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
/*
给定一个字符串S，请找出S的一个前缀和后缀，使得它们拼接后是一个回文串。
请输出这个串的最长长度。 输入描述 输入一行包含一个字符串S，由小写英文字母组成。
输出描述 输出一行包含一个整数表示答案。
 */