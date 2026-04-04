package com.njx.Basic7;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long tmp = 1;
        int cnt = 0;

        // 计算二进制位数
        while (tmp <= n) {
            tmp <<= 1;
            cnt++;
        }

        long ansZero = 0;

        // 统计 0 的个数（在有效位内）
        for (int i = 0; i < cnt; i++) {
            if (((n >> i) & 1) == 0) {
                ansZero++;
            }
        }

        long result = n - (1L << ansZero) + 1;

        System.out.println(result);
    }
}
/*
小蓝正在画三角形，他先规定了三角形的一条边的边长为x，你需要找出有多少个正整数y 满足以下所有条件：
• 1 ≤y≤ x ;
• x，y 以及x|y 这三个数可以构成一个非退化的三角形的边长。其中，x|y表示x和y的二进制按位或
(BitwiseOR）运算结果。
提示：一个三角形是非退化的，意味着它的三条边长α，b，C都必须为正，并且满足三角不等式：α十b>c、a十c>
b、b+c>a。
如果其中任何一个不等式取等号（例如a十 b=c），则该三角形是退化的（三点共线）。
输入格式
输入一行包含一个正整数α。
输出格式
输出一行包含一个整数表示答案。
 */