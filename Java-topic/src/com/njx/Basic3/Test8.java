package com.njx.Basic3;

import java.util.*;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取初始数字串
        String s = sc.nextLine();
        // 读取变换次数
        int n = sc.nextInt();
        sc.close();

        // 进行n次变换
        for (int step = 0; step < n; step++) {
            s = transform(s);
        }

        // 输出结果
        System.out.println(s);
    }

    /**
     * 对字符串进行一次变换
     * 规则：统计连续相同字符的个数，然后输出"个数+字符"
     * @param str 输入字符串
     * @return 变换后的字符串
     */
    private static String transform(String str) {
        StringBuilder result = new StringBuilder();
        int len = str.length();
        int i = 0;

        while (i < len) {
            char currentChar = str.charAt(i);
            int count = 1;

            // 统计连续相同字符的个数
            while (i + 1 < len && str.charAt(i + 1) == currentChar) {
                count++;
                i++;
            }

            // 追加"个数+字符"
            result.append(count).append(currentChar);
            i++;
        }

        return result.toString();
    }
}
/*
从×星截获一份电码，是一些数字，如下：
13
1113
3113
132113
1113122113
YY 博士经彻夜研究，发现了规律:
第一行的数字随便是什么，以后每一行都是对上一行"读出来"
比如第 2 行，是对第1行的描述，意思是：1个 1，1个3，所以是：1113
第3行，意思是：3个1,1个3，所以是：3113
请你编写一个程序，可以从初始数字开始，连续进行这样的变换。
输入描述
第一行输入一个数字组成的串，不超过100 位。
第二行，一个数字 n，表示需要你连续变换多少次，n 不超过 20。
输出描述
输出一个串，表示最后一次变换完的结果。
 */