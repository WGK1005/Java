package com.njx.Basic7;

import java.util.*;
//思路机器清奇，用贡献代替暴力循环
public class Test11 {
    public static void main(String[] args) {
        int n = 2023;
//        n = 23;
        StringBuilder ss = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            ss.append(i);
        }
        char[] cs = ss.toString().toCharArray();
        int two = 0, zero = 0, two2 = 0, three = 0;
        long res = 0;
        for (char c : cs) {
            if (c == '2') {
                two2 += zero;
                two++;
            }
            if (c == '0') {
                zero += two;
            }
            if (c == '3') {
                res += two2;
            }
        }
        System.out.println(res);
    }
}
/*
小蓝在黑板上连续写下从1到 2023 之间所有的整数，得到了一个数字序列：S=
12345678910111213..20222023。小蓝想知道S中有多少种子序列恰好等于 2023？
以下是３种满足条件的子序列（用中括号标识出的数字是子序列包含的数字）：
1[234567891[0|111[2|1[3|14151617181920212223..
1[2]34567891[0]111[2]131415161718192021222[3]..
1[2]34567891[0]111213141516171819[2]021222[3.注意以下是不满足条件的子序列，虽然包含了2、0、2、3四个数字，但是顺序不对：
1[2345678910111[2131415161718192[0|21222[3.
 */