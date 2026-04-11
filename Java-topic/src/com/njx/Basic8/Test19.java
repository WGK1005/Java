package com.njx.Basic8;

import java.util.*;

public class Test19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] monitors = new int[n];
        int[] sockets = new int[n];
        for (int i = 0; i < n; i++) {
            monitors[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sockets[i] = sc.nextInt();
        }
        Arrays.sort(monitors);
        Arrays.sort(sockets);
        int totalLength = 0;
        for (int i = 0; i < n; i++) {
            totalLength += Math.abs(monitors[i] - sockets[i]);
        }
        System.out.println(totalLength);
    }
}
/*
问题描述
在一条一维的直线上，存在n台显示器和n个电源插座。
老师给小蓝布置了一个任务：将每台显示器通过电源线与一个插座相连接（每个插座最多只能给一台显示器供电）。
同时，老师希望所消耗的电源线长度尽可能少。
请计算电源线的最小消耗长度（只需考虑直线距离）。
输入格式
输入的第一行包含一个正整数 n.
接下来 n 行，每行包含一个整数 αi，依次表示每台显示器的坐标。
接下来 n 行，每行包含一个整数 yi，依次表示每个插座的坐标。
输出格式
输出一行包含一个整数，表示电源线的最小消耗长度。
 */