package com.njx.Basic6;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long L = scanner.nextLong();
        scanner.close();

        // 找到最小的x，使得 x(x+1)/2 >= L
        long x = (long) Math.ceil((Math.sqrt(8 * L + 1) - 1) / 2);
        while (true) {
            long S = x * (x + 1) / 2;
            if ((S + L) % 2 == 0 && S >= L) {
                System.out.println(x);
                return;
            }
            x++;
        }
    }
}
/*
小A穿上了一双神奇的弹跳鞋，他可以给弹跳鞋充能x点能量并启动，然后弹跳鞋会连续弹跳α次，过程中无法停止。
其中，第i次弹跳时小A可以跳跃的距离恰好为x一i+1
小A正站在一条路上，他希望跳到距离自己L的位置，你可以认为小A只能向正反两个方向跳跃，不需要考虑路的宽度。
小A想知道，如果他只给鞋子充能一次，他在所有弹跳完成后能否停在目标位置。如果能，输出最低需要多少能量；如果不能，输出一1。
输入格式
输入包含一行一个整数，L。
输出格式
输出一行一个整数表示答案。
 */