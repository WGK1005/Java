package com.njx.Basic2;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 读取矿洞数量 n 和最大移动距离 m
        int n = scan.nextInt();
        int m = scan.nextInt();
        // 存储每个矿洞的坐标
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        // 对矿洞坐标进行排序
        Arrays.sort(arr);

        int maxOre = 0;
        int left = 0;
        // 双指针遍历矿洞区间
        for (int right = 0; right < n; right++) {
            // 若当前区间距离超过最大移动距离 m，则右移左指针
            while (left <= right && Math.min(Math.abs(arr[left]), Math.abs(arr[right])) + arr[right] - arr[left] > m) {
                left++;
            }
            // 更新最大矿石数
            maxOre = Math.max(maxOre, right - left + 1);
        }
        // 输出最多能获得的矿石单位数
        System.out.println(maxOre);
    }
}
/*
小蓝正在数轴上挖矿，数轴上一共有 n 个矿洞，第个矿洞的坐标为 α。小蓝从 0 出发，每次可以向左或向右移动1 的距离，当路过一个矿洞时，就会进行挖矿作业，获得1单位矿石，但一个矿洞不能被多次挖掘。小蓝想知道在移动距离不超过m的前提下，最多能获得多少单位矿石？
输入格式
输入的第一行包含两个正整数n，m，用一个空格分隔。
第二行包含 n 个整数α1,α2,···，αn，相邻整数之间使用一个空格分隔。
输出格式
输出一行包含一个整数表示答案。
 */