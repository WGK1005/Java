package com.njx.TanXin;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n=s.length();
        int ans=0;
        int i=0;
        while (i<n-1){
            char a=s.charAt(i);
            char b=s.charAt(i+1);
            if (a==b||a=='?'||b=='?'){
                ans++;
                i+=2;
            }else{
                i++;
            }
        }
        System.out.println(ans);
    }
}
/*
  有一个长度为 的 01 串，其中有一些位置标记为？，这些位置上可以任意填充0或者1，请问如何填充这些位置使得这个01串中出现互不重叠的00和11子串最多，输出子串个数。
输入格式
输入一行包含一个字符串。
输出格式
输出一行包含一个整数表示答案。
 */