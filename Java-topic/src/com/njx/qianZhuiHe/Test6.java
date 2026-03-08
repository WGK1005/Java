package com.njx.qianZhuiHe;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        long totalSubstrings = (long) n * (n + 1) / 2;//核心算法
        long ans = 0;

        // 对每个字符 a-z
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // 找出不含该字符的段
            long sumWithout = 0;
            int lastPos = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    // 从 lastPos+1 到 i-1 是不含该字符的段
                    int len = i - lastPos - 1;
                    sumWithout += (long) len * (len + 1) / 2;
                    lastPos = i;
                }
            }
            // 最后一段
            int len = n - lastPos - 1;
            sumWithout += (long) len * (len + 1) / 2;

            // 包含该字符的子串数 = 总子串数 - 不含该字符的子串数
            ans += totalSubstrings - sumWithout;
        }

        System.out.println(ans);
    }
}


//对于一个字符串 S，我们定义 S 的分值 f(S)为 S 中出现的不同的字符个数。例如 f(“aba"）= 2，f(“abc"）=3, f(“aaa") = 1。
//现在给定一个字符串 S[0...n一1]（长度为 n），请你计算对于所有 S 的非空子串 S[..j](0 ≤i ≤ j < n),f(S[i..j]) 的和是多少。
//输入描述
//输入一行包含一个由小写字母组成的字符串 S。其中，1≤n≤105。
//输出描述
//输出一个整数表示答案。
//按照蓝桥杯java语言给出解析语代码


/*
//很神奇的方法，copy，有时间研究一下
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        long res = 0;
        for(int i = 0;i < 26;i++){
            arr[i] = -1;
        }
        String s = sc.nextLine();
        String[] str = s.split("");
        //下次出现的位置默认为字符串末尾，因为同一轮遍历中此值不对结果做贡献
        int willIndex = str.length; // ababc = 5,将来出现的位置，直接写字符串长度
        for(int i = 0;i < str.length;i++){
            int lastIndex = arr[str[i].charAt(0)-97];
            res += (long)(i - lastIndex)*(willIndex - i); //子串个数算法
            //算法核心=（本次出现的位置-上次出现的位置）*（将来最近一次出现的位置-本次出现的位置），
            arr[str[i].charAt(0)-97] = i;
        }
        System.out.println(res);
    }
}
 */