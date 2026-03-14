package com.njx.TanXin;

import java.util.*;
//尽力了，双指针加贪心，通过率只有10，感觉有点挫败，不愧是国赛的题没表面那么简单
public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        boolean[] used = new boolean[n];

        int ans = 0;

        for(int i = 0; i < n; i++){

            if(used[i]) continue;

            for(int j = i + 1; j < n; j++){

                if(!used[j] && a[j] - a[i] == 1){

                    used[i] = true;
                    used[j] = true;

                    ans++;
                    break;
                }
            }
        }


        System.out.println(ans);
        }
    }


/*
小蓝有一个长度为 n 的正整数数组 A =[α1,α2,···,αn]，每当他从中拿出一对（α,α;)，其中i<j，他会得到它们的差b = α－α。然而，他特别喜欢整数 1，所以他想知道在数组A 中最多能同时取出多少对正整数（α，αj），每个数最多被取一次，使得它们的差为 1。
输入格式
输入的第一行包含一个正整数n。
第二行包含n 个正整数α1,α2,···，αn，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */