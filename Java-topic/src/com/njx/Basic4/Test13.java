package com.njx.Basic4;

import java.util.*;
import java.io.*;
//其实再问最长的接龙序列是多少，序列不管多长无非是0到9结尾，重头开始遍历每一个数
// 对于一个数分别求出开头数字head和结尾数字tail，可以产生一个接龙序列（将前面以head结尾的最长序列与该数字对接即长度加一）
// 那么就可更新一次以tail结尾的接龙序列长度（当然有可能不更新要和之前的比较）。 最后得到分别以0到9结尾的最长接龙序列，再从里面找到最长的，与n相减即可
public class Test13 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int []dp=new int[10];
        int n=sc.nextInt();
        String []s=new String[n];
        for(int i=0;i<n;i++)
            s[i]=sc.next();
        for(int i=0;i<n;i++){
            int head=s[i].charAt(0)-'0';
            int tail=s[i].charAt(s[i].length()-1)-'0';
            dp[tail]=Math.max(dp[head]+1,dp[tail]);
        }
        int max=0;
        for(int i=0;i<10;i++) max=Math.max(max,dp[i]);
        System.out.println(n-max);
    }
}
/*
对于—个长度为K的整数数列：A1，A2，·，AK，我们称之为接龙数列当且仅当A₂的首位数字恰好等于Ai-1的末位数字(2≤i≤K)。
例如12,23，35,56，61，11是接龙数列；12，23，34，56不是接龙数列，因为56的首位数字不等于 34 的末位数字。所有长度为1的整数数列都是接龙数列。
现在给定一个长度为N的数列 A1，A2，·，AN，请你计算最少从中删除多少个数，可以使剩下的序列是接龙序列?
输入格式
第一行包含一个整数N。
第二行包含N个整数A1，A2，··，AN。
输出格式
一个整数代表答案。
 */