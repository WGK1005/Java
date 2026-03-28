package com.njx.Basic4;

import java.util.*;
import java.io.*;
public class Test9 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        long[] w = new long[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            w[i] = Long.parseLong(str[i]);
        }

        // 排序
        Arrays.sort(w);

        long ans = 0;

        // 贪心配对
        for (int i = 0; i < n; i++) {
            ans += w[i] * w[2 * n - 1 - i];
        }

        System.out.println(ans);
    }
}
/*
小明的妈妈给他买了个玩具，但是为了同时考察他的智力，只给了他 2 ×  个零件，第i个零件的重量为 w（1≤i≤2×n)。
其中任意两个零件都可以拼接成一个玩具，这个玩具的权重就等于拼接所用的两个零件的重量的乘积。小明的妈妈希望小明能够使用这2× n个零件拼接出n个玩具（每个零件必须使用且只能用一次），使得所有玩具的权重的和最小。小明希望你帮帮他计算出最小的权重和。
输入描述
输入共 2 行。
第一行为一个正整数n。
第二行为 2 ×n个由空格隔开的整数 w1, w2,., w2×no
输出描述
输出共1行，一个整数。
 */