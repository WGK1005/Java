package com.njx.Basic8;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        HashSet<Set<String>> set=new HashSet<>();
        while (n-->0) {
            String s=scan.next();
            HashSet<String> a=new HashSet<>();
            String[] str=s.substring(1, s.length()-1).split(",");
            for (int i = 0; i < str.length; i++) {
                a.add(str[i]);
            }
            set.add(a);
        }
        System.out.println(set.size());
    }
}
/*
小蓝有n 个集合，这些集合中的元素还未去重。每个集合S最多含有5 个长度不大于4的仅含小写字母的字符串Si,j o
你需要计算小蓝的这些集合去重后有多少个（集合内的元素和集合之间都要去重）。
每个集合用{"abc"}，{"a","b","c","d"}的形式输入（无空格）。
输入格式
输入的第一行包含整数 n。
接下来n 行，每行包含一个字符串，描述一个集合Si。
输出格式
输出一行，包含一个整数表示答案。
 */