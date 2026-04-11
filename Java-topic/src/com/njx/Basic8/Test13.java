package com.njx.Basic8;

import java.util.*;

public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long sum=0;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                sum^=num;//数学学魔怔了，还在想怎么转二进制，直接异或就行了，哈哈哈
            }
            if (sum==0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
/*
研究员小蓝受到实验室主任的指示，需要对实验室新研发的n个新型能量电池进行分组实验。
这N个能量电池的能量值分别用A1，A2，···，A 表示，每个能量值都是一个整数。
为了保证实验的安全性，小蓝需要将这N个能量电池分成两组，使得这两组能量电池的能量值异或和相等。
能量值的异或和计算方法如下：对于一个集合S，其异或和等于集合中所有元素的按位异或结果。例如，集合{1，2，3}的异或和为1⊕2⊕3=0，其中⊕表示异或运算。
现在，小蓝想知道，这n个能量电池能否分成两组，使得这两组能量电池的能量值异或和相等。注意，每组至少包含一个能量电池。
请你帮帮他！
输入格式
输入的第一行包含一个整数T，表示测试用例的数量。
每个测试用例占两行：
● 第一行包含一个整数Ⅳ，表示能量电池的数量。
• 第二行包含n个整数A1，A2，···，AN，表示每个能量电池的能量值。
输出格式
对于每个测试用例，输出一行。如果可以将能量电池分成两组，使得这两组能量电池的能量值异或和相等，则输出YES；否则，输出NO。
 */