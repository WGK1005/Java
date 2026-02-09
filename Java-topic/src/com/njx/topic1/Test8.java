package com.njx.topic1;

import java.util.*;
public class Test8 {
    public static void main(String[] args) {
        //福尔摩斯从 X 星收到一份资料，全部是小写字母组成。
        //他的助手提供了另一份资料：许多长度为 8 的密码列表。
        //福尔摩斯发现，这些密码是被打乱后隐藏在先前那份资料中的。
        //请你编写一个程序，从第一份资料中搜索可能隐藏密码的位置。要考虑密码的所有排列可能性。
        //输入描述
        //输入第一行：一个字符串 s 全部由小写字母组成，长度小于 1024*1024。
        //紧接着一行是一个整数n表示以下有n 行密码，1≤n≤1000。
        //紧接着是n行字符串，都是小写字母组成，长度都为 8。
        //输出描述
        //输出一个整数, 表示每行密码的所有排列在s 中匹配次数的总和。

        //这是gpt的答案，未通过
        Scanner sc = new Scanner(System.in);

        // 第一份资料：长字符串
        String S = sc.nextLine();

        // 第二份资料：密码个数
        int m = sc.nextInt();
        sc.nextLine(); // 吃掉换行

        while (m-- > 0) {
            String P = sc.nextLine(); // 长度为 8 的密码

            int[] cntP = new int[26];
            int[] cntS = new int[26];

            // 统计密码字母出现次数
            for (char c : P.toCharArray()) {
                cntP[c - 'a']++;
            }

            int len = S.length();

            // 初始化第一个窗口
            for (int i = 0; i < 8; i++) {
                cntS[S.charAt(i) - 'a']++;
            }

            // 判断第一个窗口
            if (Arrays.equals(cntP, cntS)) {
                System.out.println(0);
            }

            // 滑动窗口
            for (int i = 8; i < len; i++) {
                // 加右边
                cntS[S.charAt(i) - 'a']++;
                // 去左边
                cntS[S.charAt(i - 8) - 'a']--;

                if (Arrays.equals(cntP, cntS)) {
                    System.out.println(i - 7);
                }
            }
        }

        sc.close();

    }
}

//以下是蓝桥杯的代码分享，能通过，但是存在内存溢出等问题
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 读取第一行输入的字符串 s
//        String s = sc.nextLine();
//
//        // 如果字符串 s 的长度小于 8，则直接输出 0 并返回
//        if (s.length() < 8) {
//            System.out.println(0);
//            return;
//        }
//
//        // 读取整数 n
//        int n = sc.nextInt();
//
//        // 读取换行符，确保下一次读取的是字符串
//        sc.nextLine();
//
//        // 初始化答案变量
//        int ans = 0;
//
//        // 循环处理 n 个字符串
//        while (n-- > 0) {
//            // 读取一个字符串并转换为字符数组
//            char[] t = sc.nextLine().toCharArray();
//
//            // 对字符数组进行排序
//            Arrays.sort(t);
//
//            // 遍历字符串 s 的所有长度为 8 的子串
//            for (int j = 0; j <= s.length() - 8; j++) {
//                // 获取长度为 8 的子串并转换为字符数组
//                char[] temp = s.substring(j, j + 8).toCharArray();
//
//                // 对子串进行排序
//                Arrays.sort(temp);
//
//                // 如果排序后的子串与 t 相等，则增加答案计数
//                if (Arrays.equals(temp, t)) {
//                    ans++;
//                }
//            }
//        }
//
//        // 输出最终的答案
//        System.out.println(ans);
//    }
//}