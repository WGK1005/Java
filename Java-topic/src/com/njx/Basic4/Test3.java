package com.njx.Basic4;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        int k = scan.nextInt();
        int nk=k;
        String s = scan.next();
        LinkedList<Character> list=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            while(!list.isEmpty()&&s.charAt(i)<list.getLast()&&nk>0){
                list.removeLast();
                nk--;
            }
            list.addLast(s.charAt(i));
        }
        for (int j = 0; j < n-k; j++) {
            System.out.print(list.removeFirst());
        }
        scan.close();
    }
}
/*
给定一个由大写字母组成的长度为的字符串，请在字符串中删除 m 个字符，使得剩下的字符串的字典序最小。
输入格式
输入的第一行包含两个整数n,m，用一个空格分隔。
第二行包含一个长度为n的字符串。
输出格式
输出一行包含一个长为n－m的字符串，表示答案。
 */