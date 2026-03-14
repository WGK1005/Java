package com.njx.BaoLi;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c[] = str.toCharArray();
        int y = 0;
        int f = 0;
        for (int i = 0; i < c.length; i++) {
            if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                y++;
            }else {
                f++;
            }
        }
        System.out.println(y);
        System.out.println(f);
    }
}
/*
题目描述
给定一个单词，请计算这个单词中有多少个元音字母，多少个辅音字母。
元音字母包括 a, e,i, o,u，共五个，其他均为辅音字母。
输入描述
输入格式:
输入一行，包含一个单词，单词中只包含小写英文字母。单词中的字母个数不超过100。
输出描述
输出两行，第一行包含一个整数，表示元音字母的数量。
第二行包含一个整数，表示辅音字母的数量。
 */