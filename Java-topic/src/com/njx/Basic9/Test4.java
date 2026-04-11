package com.njx.Basic9;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // 比如 A4

        int k = s.charAt(1) - '0'; // 提取数字

        int a = 1189;
        int b = 841;

        for (int i = 0; i < k; i++) {
            int temp = a;
            a = b;
            b = temp / 2;
        }

        System.out.println(a);
        System.out.println(b);

    }
}
/*
问题描述
在ISO 国际标准中定义了A0 纸张的大小为1189mmX841mm，将A0纸沿长边对折后为A1纸，大小为841mmX594mm，在对折的过程中长度直接取下整 (实际裁剪时可能有损耗)。将A1纸沿长边对折后为A2纸，依此类推。
输入纸张的名称，请输出纸张的大小。
输入格式
输入一行包含一个字符串表示纸张的名称, 该名称一定是A0、A1、A2、A3、A4、A5、A6、A7、A8、A9 之—。
输出格式
输出两行，每行包含一个整数，依次表示长边和短边的长度。
 */