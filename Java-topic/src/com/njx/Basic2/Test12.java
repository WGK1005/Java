package com.njx.Basic2;

import java.util.*;
//非常典型的分类讨论，主要是将奇数偶数都想到了规律
public class Test12 {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 特殊情况：变化次数为0
        if (c == 0) {
            if ((a == 0 && b == 0) || (a > 0 && b > 0)) {
                System.out.println(-1);
            } else {
                // 只有一种颜色的珠子
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < a; i++) sb.append('L');
                for (int i = 0; i < b; i++) sb.append('Q');
                System.out.println(sb.toString());
            }
            return;
        }

        // 计算最大可能的变化次数
        int mx = 2 * Math.min(a, b) + (a == b ? -1 : 0);
        int mn = 1;

        // 检查c是否在可行范围内
        if (c > mx || c < mn) {
            System.out.println(-1);
            return;
        }

        // c为奇数的情况：LQLQ 或 QLQL
        if (c % 2 == 1) {
            int cnta = (c + 1) / 2;
            int cntb = (c + 1) / 2;
            a -= cnta;
            b -= cntb;

            StringBuilder sb = new StringBuilder();
            // 添加前面的L
            for (int i = 0; i < a; i++) sb.append('L');
            // 添加交替的LQ
            for (int i = 0; i < cnta; i++) sb.append("LQ");
            // 添加后面的Q
            for (int i = 0; i < b; i++) sb.append('Q');

            System.out.println(sb.toString());
        }
        // c为偶数的情况：LQLQL 或 QLQLQ
        else {
            int cnta = c / 2 + 1;
            int cntb = c / 2;

            // 情况1：以L开头和结尾
            if (a >= cnta && b >= cntb) {
                a -= cnta;
                b -= cntb;

                StringBuilder sb = new StringBuilder();
                // 添加前面的L
                for (int i = 0; i < a; i++) sb.append('L');
                // 添加交替的LQ
                for (int i = 0; i < cntb; i++) sb.append("LQ");
                // 添加后面的Q
                for (int i = 0; i < b; i++) sb.append('Q');
                // 添加最后一个L
                sb.append('L');

                System.out.println(sb.toString());
            }
            // 情况2：以Q开头和结尾
            else if (a >= cntb && b >= cnta) {
                // 交换cnta和cntb
                int temp = cnta;
                cnta = cntb;
                cntb = temp;

                a -= cnta;
                b -= cntb;

                StringBuilder sb = new StringBuilder();
                sb.append("QL");
                // 添加前面的L
                for (int i = 0; i < a; i++) sb.append('L');
                // 添加交替的QL
                for (int i = 0; i < cnta - 1; i++) sb.append("QL");
                sb.append("Q");
                // 添加后面的Q
                for (int i = 0; i < b; i++) sb.append('Q');

                System.out.println(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        int T = 1;
        // 如果有多个测试用例，可以取消注释
        // Scanner sc = new Scanner(System.in);
        // T = sc.nextInt();

        while (T-- > 0) {
            solve();
        }
    }
}
/*
小蓝有A颗蓝珠（用字符‘L'表示）和B颗桥珠（用字符“Q'表示），他打算用这些珠子串成一条项链。
他认为项链的美感主要体现在其视觉“变化”上：当项链中任意两个相邻的珠子种类不同时，就记为产生了一次“变化”
为了系统地研究不同排列的美感，小蓝将每一种项链的排列方式表示为一个长度为 A + B 的字符串。
这个字符串由 A个字符‘L'和B个字符‘Q'组成。相应地，一条项链的“变化次数”即为这个字符串中，所有相邻且不相同的字符对的数目。
例如，如果项链的排列是“LLQLQ"，那么:·第1 个‘L'和第 2 个‘L'相同，无变化。
·第2 个L'和第3 个‘Q'不同，产生了 1 次变化。
·第3个‘Q'和第4 个L'不同，产生了1次变化。
·第 4 个L'和第5个‘Q'不同，产生了1次变化。
排列“LLQLQ" 的总“变化次数”为 3。
现在，小蓝希望找到一种项链排列，使其总“变化次数”恰好为 C。对此，请你帮他在所有满足这一条件的排列中，找出字典序最小的那一个。
如果不存在任何满足条件的排列方式，则输出 -1。
输入格式
输入仅一行，包含三个整数A，B 和C，分别表示蓝珠数量、桥珠数量和目标变化次数。
输出格式
输出一个长度为A + B 的字符串，表示字典序最小的满足条件的排列。如果不存在这样的排列，则输出－1。
 */