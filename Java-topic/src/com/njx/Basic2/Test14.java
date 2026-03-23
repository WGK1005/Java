package com.njx.Basic2;

import java.util.*;
//完美通过，思路一致算是自己写的吧
public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            boolean hasLower = false;
            boolean hasUpper = false;
            boolean hasDigit = false;
            int specialCount = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    hasLower = true;
                    if (c == 'o') specialCount++;
                }
                else if (c >= 'A' && c <= 'Z') {
                    hasUpper = true;
                    if (c == 'O') specialCount++;
                }
                else if (c >= '0' && c <= '9') {
                    hasDigit = true;
                    if (c == '0') specialCount++;
                }
            }
            int missingCount = 0;
            if (!hasLower) missingCount++;
            if (!hasUpper) missingCount++;
            if (!hasDigit) missingCount++;
            if (missingCount == 0) {
                System.out.println(0);
                continue;
            }
            if (specialCount < missingCount) {
                System.out.println(-1);
                continue;
            }
            boolean canGetMissing = true;
            if (!hasUpper) {
            }
            if (!hasLower) {
            }
            if (!hasDigit) {
            }
            if (missingCount <= specialCount) {
                System.out.println(missingCount);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
/*
小蓝是蓝桥云课的忠实用户，他在平台上注册了 n 个账号，每个账号的密码都是一串仅由大小写字母、数字构成的字符串。
最近，蓝桥云课为了提升账户安全性，强制要求所有用户修改密码以符合新的安全策略：密码必须至少包含一个小写字母、一个大写字母和一个数字。
小蓝不想大幅修改他常用的密码，因为他已经非常习惯了。于是，他打算进行一些简单的替换操作来修改密码，以尽可能保留原密码的结构。
具体来说，每次操作，他可以将密码中的大写字母 〇、小写字母○和数字 0 做一次互相替换即一次操作可以是以下操作之一：
·将其中的一个大写字母○改成小写字母○;·将其中的一个大写字母〇改成数字0;·将其中的一个小写字母○改成大写字母〇;
·将其中的一个小写字母○改成数字0；·将其中的一个数字0改成大写字母〇；·将其中的一个数字0改成小写字母○。
现在，小蓝希望你帮助他计算每个账号的密码至少需要多少次替换操作才能符合新的安全策略。
如果无论如何替换都无法满足新策略，则输出一1，表示该密码无法通过替换操作变得有效。
输入格式
输入的第一行包含一个整数n，表示小蓝的账号数量。
接下来 n 行，每行包含一个仅由大小英文字母、数字构成的字符串S，表示一个密码。
输出格式
输出 n 行，每行包含一个整数，表示修改对应密码所需的最小操作次数。如果无法满足新策略，则输出一1。
 */