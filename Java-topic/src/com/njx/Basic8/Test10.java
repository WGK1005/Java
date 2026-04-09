package com.njx.Basic8;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt(), w = sc.nextInt();
        int[] arr = {2, 0, 2, 5};
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int temp = (j + i) % 4;
                System.out.print(arr[temp]);
            }
            System.out.println();
        }
    }
}
/*
小蓝要画一个2025图形。图形的形状为一个h×w的矩形，其中h 表示图形的高，ω表示图形的宽。
当h=5，w= 10时，图形如下所示：
2025202520
0252025202
2520252025
5202520252
2025202520
图形的规律是：
第一行用 2025 重复填入，第二行开始，每行向左移动一个字符，用2025重复填入。给定h，W，请输出对应的图形。
输入格式
输入的第一行包含两个正整数h，w，用一个空格分隔。
输出格式
输出若干行，表示对应的图形。
 */