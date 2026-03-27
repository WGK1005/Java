package com.njx.Basic4;

import java.util.*;
//蓝桥杯不愧为暴力杯，这样大概的想法居然能100，没有全是llllllll或者rrrrrrrr的
public class Test6 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        int a=0,b=0;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='L'){
                a++;
            }
            if (s.charAt(i)=='R'){
                b++;
            }
            if(a==b){
                count++;
            }
        }
        System.out.println(count);
    }
}
/*
给定一个由大写字母 L 和 R 组成的长度为 n 的字符串。一个左右相同的位置是指一个位置i，字符串中的前i 个字符中L的数量等于 R的数量。请问给定的字符串中有几个左右相同的位置。
例如：LRLLRRRLR 中有 3 个左右相同的位置，分别是位置
2、6、 8。
输入格式
输入一行包含一个字符串，由大写字母L和R 组成。
输出格式
输出一行包含一个整数，表示左右相同的位置的数量。
 */