package com.njx.Basic3;

import java.util.*;

public class Test13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if (ch[i]>='x' && ch[i]<='z') {
                System.out.print((char)(ch[i]-23));
            }else {
                System.out.print((char)(ch[i]+3));
            }
        }
    }
}
/*
题目描述
给定一个单词，请使用凯撒密码将这个单词加密。
凯撒密码是一种替换加密的技术，单词中的所有字母都在字母表上向后偏移 3 位后被替换成密文。即 α 变为 d，b 变为e，···，w变为，变为α，y变为b，变为c。
输入描述
输入格式:
输入一行，包含一个单词，单词中只包含小写英文字母，单词中的字母个数不超过100。
输出描述
输出一行，表示加密后的密文。
 */