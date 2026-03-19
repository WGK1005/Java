package com.njx.Basic;

import java.util.*;
import java.io.*;

public class Test15 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args)throws IOException{
        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        char[] c = in.readLine().toCharArray();
        Arrays.sort(c);
        if(c[0]==c[x-1]){
            out.print(c[0]);
            //把字典序最小的糖果分了后，就分看剩下的糖果是否相同，相同则尽量均分，否则就都给一个人，这样·能保证大的字符串字典序最小
            if(c[x]==c[n-1]){
                for(int i=0; i<(n-x+x-1)/x; i++) out.print(c[x]);       //(n-x+x-1)/x中的+x-1代表上取整
            }else{
                for(int i=x; i<n; i++) out.print(c[i]);
            }
        }else{
            out.print(c[x-1]);        //如果最小的糖果不够分，那么剩下的人分到的糖果字典序肯定是最大的，所以可以直接输出
        }
        out.flush();
        out.close();
    }
}

/*
最近暑期特训算法班的同学们表现出色，他们的老师肖恩决定给他们分发糖果。肖恩购买了n 个不同种类的糖果，用小写的阿拉伯字母表示。每个糖果必须分发给一个同学，并且每个同学至少要分到一个糖果。同学们的开心程度定义为他们所分到的糖果组成的字符串8[]的字典序。肖恩希望同学们的开心程度相差尽量小，因此他要找到一种方案，使得所有糖果组成的字符串中字典序最大的字符串尽可能小。请输出能够实现字典序最小可能的max(s[1], s[2], s[3], ..., s[x]) 。
输入描述
第一行输入两个整数 n 和∞，分别表示有n 个糖果α 个同学。
第二行输入一个长度为n的字符串 S，S[表示第 个糖果的种类。
数据保证 1 ≤n ≤ 10°,1 ≤∞ ≤n,S[] ∈[α',z] 。
输出描述
输出一个字符串，为所有糖果组成的字符串中字典序最大的字符串最小的可能值。
 */