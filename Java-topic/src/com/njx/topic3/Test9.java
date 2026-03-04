package com.njx.topic3;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        for (int i = 2000; i <= 3200; i++) {
            if (i % 7 == 0 && i % 5 != 0) {
                System.out.println(i);
            }
        }
    }
}
/**
 * 题目：编写一个程序，查找所有此类数字，它们可以被7整除，但不能是5的倍数（在2000和3200之间（均包括在内））.
 */