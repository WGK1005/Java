package com.njx.TanXin;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();

        int n = s.length();
        if (n % k != 0) {
            System.out.println(-1);
            sc.close();
            return;
        }

        int len = n / k;
        int ans = 0;

        for (int pos = 0; pos < len; pos++) {
            int[] cnt = new int[26];
            int maxFreq = 0;

            for (int block = 0; block < k; block++) {
                char c = s.charAt(block * len + pos);
                int idx = c - 'a';
                cnt[idx]++;
                if (cnt[idx] > maxFreq) {
                    maxFreq = cnt[idx];
                }
            }

            ans += k - maxFreq;
        }

        System.out.println(ans);
        sc.close();
    }
}
/*
如果一个字符串S恰好可以由某个字符串重复K次得到，我们就称 S 是 K 次重复字符串。例如 abcabcabc 可以看作是 abc 重复3 次得到，所以 abcabcabc 是3次重复字符串。
同理 aaaaaa 既是 2 次重复字符串、又是 3 次重复字符串和 6 次重复字符串。
现在给定一个字符串 S，请你计算最少要修改其中几个字符，可以使S变为一个K次字符串？
输入描述
输入第一行包含一个整数K。
第二行包含一个只含小写字母的字符串S。
其中, 1 ≤ K ≤ 10°,1 ≤|S| ≤ 10°。其中|S|表示 S的长度。
输出描述
输出一个整数代表答案。如果S无法修改成K 次重复字符串，输出－1。
 */