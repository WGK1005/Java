package com.njx.Basic3;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        // 计算所有数字的和
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        // 数学公式计算数字根
        int result = sum == 0 ? 0 : 1 + (sum - 1) % 9;

        System.out.println(result);
    }
}

