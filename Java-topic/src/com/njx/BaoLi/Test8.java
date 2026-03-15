package com.njx.BaoLi;

import java.util.*;
//用暴力但是和我想得有点不一样，等有时间再看看
public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入字符串
        String s = sc.next();

        int n = s.length();

        // 统计三种字母数量
        int b = 0, a = 0, t = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'B') b++;
            else if (c == 'A') a++;
            else t++;
        }

        // 六种排列方式
        String[] orders = {
                "BAT", "BTA",
                "ABT", "ATB",
                "TBA", "TAB"
        };

        int ans = Integer.MAX_VALUE;

        // 枚举每一种排列
        for (String order : orders) {

            // 构造目标字符串
            String target = "";

            for (int i = 0; i < order.length(); i++) {

                char c = order.charAt(i);

                if (c == 'B') {
                    for (int j = 0; j < b; j++) target += "B";
                }

                if (c == 'A') {
                    for (int j = 0; j < a; j++) target += "A";
                }

                if (c == 'T') {
                    for (int j = 0; j < t; j++) target += "T";
                }
            }

            // 统计错位数量
            int mismatch = 0;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != target.charAt(i)) {
                    mismatch++;
                }
            }

            // 计算交换次数
            int swaps = mismatch / 2;

            ans = Math.min(ans, swaps);
        }

        // 输出最小交换次数
        System.out.println(ans);
    }
}
/*
IT 产业人才需求节节攀升。业内巨头百度、阿里巴巴、腾讯（简称 BAT）在某海滩进行招聘活动。
招聘部门一字排开。由于是自由抢占席位，三大公司的席位随机交错在一起，形如：BABTATT，这使得应聘者十分别扭。
于是，管理部门要求招聘方进行必要的交换位置，使得每个集团的席位都挨在一起。即最后形如：BBAAATTT 这样的形状，当然，也可能是：AAABBTTT 等。
现在，假设每次只能交换2个席位，并且知道现在的席位分布，你的任务是计算：要使每个集团的招聘席位都挨在一起需要至少进行多少次交换动作。
输入描述
输入是一行n 个字符（只含有字母 B、A或T），表示现在的席位分布。
输出描述
输出是一个整数，表示至少交换次数。
 */