package com.njx.Basic6;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int A =scan.nextInt();
        int B =scan.nextInt();
        int C =scan.nextInt();

        int max =Math.max(A,Math.max(B,C));
        int min =Math.min(A,Math.min(B,C));
        int mid=A+B+C-max-min;

        if(A==B||A==C||B==C||mid==B){
            System.out.println(0);
            return;
        }
        //策略1:让随便两个指针长度相等. abs为绝对值
        int op1=Math.min(Math.abs(A-B),Math.min(Math.abs(A-C),Math.abs(B-C)));
        //策略2:让B成为第二指针
        int minAC=Math.min(A,C);
        int maxAC=Math.max(A,C);
        int op2;
        if (B>=maxAC&&B<=minAC){
            op2=0;
        }else if(B>maxAC){
            op2=B-maxAC;
        }else{
            op2=Math.max(A,C)-B;
        }
        System.out.println(Math.min(op1,op2));
        scan.close();
    }
}
/*
蓝桥小镇的钟表铺里，工匠小蓝正在修复一座三针时钟。其中，时针的长度为A，分钟针的长度为 B，秒针的长度为C，均为正整数。
制造商为追求独特的设计，设定了以下规则：
• 三根指针的长度互不相同，即A≠B，A≠C，B ≠ C;
• 将三根指针的长度从大到小排序后，第二长的指针必须是时针（长度A）或秒针（长度C）。
然而，这些规则会导致指针运行时相互干扰，影响时钟的稳定性。于是，小蓝决定调整指针长度，
打破上述规则：要么三根指针的长度不互不相同，要么第二长的指针不是A或C。他可以执行以下三种操作：
• 将时针的长度A减少1;
• 将分钟针的长度B减少1；
• 将秒针的长度C减少1。
调整后的指针长度必须为正整数，即A，B，C>0。
现在，请你帮助小蓝计算，打破制造商规则所需的最小操作次数。
输入格式
输入一行，包含三个正整数A、B、C，分别表示时针、分钟针和秒针的初始长度。
 */