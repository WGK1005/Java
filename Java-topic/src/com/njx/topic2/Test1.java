package com.njx.topic2;

import java.util.Scanner;

public class Test1 {
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        //小明对类似于hello这种单词非常感兴趣，这种单词可以正好分为四段，第一段由一个或多个辅音字母组成，第二段由一个或多个元音字母组成，第三段由一个或多个辅音字母组成，第四段由一个或多个元音字母组成。
        //给定一个单词，请判断这个单词是否也是这种单词，如果是请输出yes，否则请输出no。
        //元音字母包括 a,e,i, o, u，共五个，其他均为辅音字母。
        //输入描述
        //输入一行，包含一个单词，单词中只包含小写英文字母。单词中的字母个数不超过100。
        //输出描述
        //输出答案，或者为yes，或者为no。

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int n = s.length();
        int state = 0; // 当前段号
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);

            if (state == 0) { // 第一段：辅音
                if (!isVowel(c)) {
                    i++;
                } else {
                    state = 1;
                }
            } else if (state == 1) { // 第二段：元音
                if (isVowel(c)) {
                    i++;
                } else {
                    state = 2;
                }
            } else if (state == 2) { // 第三段：辅音
                if (!isVowel(c)) {
                    i++;
                } else {
                    state = 3;
                }
            } else { // state == 3 第四段：元音
                if (isVowel(c)) {
                    i++;
                } else {
                    System.out.println("no");
                    return;
                }
            }
        }

        // 必须刚好走完 4 段
        if (state == 3) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}


