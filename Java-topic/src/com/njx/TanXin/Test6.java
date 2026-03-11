package com.njx.TanXin;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();

        char[] s=start.toCharArray();
        char[] e=end.toCharArray();

        int n = start.length();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] != e[i]) {
                count++;
                // 翻转当前硬币和下一个硬币
                s[i] = (s[i] == '*') ? 'o' : '*';
                s[i+1] = (s[i+1] == '*') ? 'o' : '*';
            }
        }
        System.out.println(count);
    }
}
/*
小明正在玩一个"翻硬币"的游戏。
桌上放着排成一排的若干硬币。我们用＊表示正面，用○表示反面（是小写字母，不是零）。
比如，可能情形是：**00***0000;
如果同时翻转左边的两个硬币，则变为：0000***0000。
现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？
我们约定：把翻动相邻的两个硬币叫做一步操作。
输入描述
两行等长的字符串，分别表示初始状态和要达到的目标状态。
每行的长度<1000。
输出描述
一个整数，表示最小操作步数。
 */