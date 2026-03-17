package com.njx.Basic;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入数据
        int m = scanner.nextInt(); // A 的人数
        int n = scanner.nextInt(); // B 的人数

        // 计算层数 num
        // 根据公式 (num + 1) * num / 2 == n + m 推导得出 num
        int num = (int) Math.sqrt((m + n) * 2);

        int ans = 0;
        // 遍历所有可能的状态组合
        for (int i = 0; i < (1 << num); i++) { // num 层的最下层是 num 个机器人，摆法有 2 的 num 次方种
            if (check(i, num, m, n)) { // 调用 check 方法检查当前状态是否符合条件
                ans++; // 如果符合条件，则计数器加一
            }
        }
        // 输出结果
        System.out.println(ans);
    }
    private static boolean check(int now, int num, int m, int n) {
        int numA = 0, numB = 0; // 分别记录 A 和 B 的数量

        // 从最底层开始向上检查
        for (int i = num; i >= 1; i--) { // i 是层数也是机器人个数
            // 使用 Integer.bitCount() 方法快速求出二进制下 1 的个数
            numB += Integer.bitCount(now); // 统计当前层中 B 的数量
            numA += i - Integer.bitCount(now); // 统计当前层中 A 的数量

            // 更新上一层的状态
            now ^= now >> 1; // 将当前层的状态向右移一位
            now &= ((1 << (i - 1)) - 1); // 保留前 i - 1 位
        }

        // 检查最终统计的数量是否等于给定的数量
        return numA == m && numB == n;
    }
}

/*
X星球的机器人表演拉拉队有两种服装，A和 B。他们这次表演的是搭机器人塔。
类似：
A
BB
ABA
AABB
BBBAB
ABABBA
队内的组塔规则是：
A 只能站在 AA 或 BB 的肩上。B 只能站在 AB 或 BA 的肩上。
你的任务是帮助拉拉队计算一下，在给定 A与 B 的人数时，可以组成多少种花样的塔。
输入描述
输入一行两个整数 M,N （0< M, N < 500）,分别表示 A、B 的人数，保证人数合理性。
输出描述
要求输出一个整数，表示可以产生的花样种数。
 */