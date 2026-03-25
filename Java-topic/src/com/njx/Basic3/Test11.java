package com.njx.Basic3;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.next();
        String t=in.next();
        int index=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==t.charAt(index))
                index++;
        System.out.print(index);
    }
}
/*
题目描述
我们称一个字符串S包含字符串T是指T是S的一个子序列，即可以从字符串S中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与T完全一样。
给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符被S包含？
输入描述
输入两行，每行一个字符串。第一行的字符串为S，第二行的字符串为T。两个字符串均非空而且只包含大写英文字母。
其中, 1 ≤|T| ≤|S| ≤ 1000.
输出描述
输出一个整数，表示答案。
 */