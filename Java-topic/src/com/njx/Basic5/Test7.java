package com.njx.Basic5;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Test7 {
        static class FastScanner {
            private final InputStream in;
            private final byte[] buffer = new byte[1 << 16];
            private int ptr = 0, len = 0;

            FastScanner(InputStream is) {
                in = is;
            }

            private int read() throws IOException {
                if (ptr >= len) {
                    len = in.read(buffer);
                    ptr = 0;
                    if (len <= 0) return -1;
                }
                return buffer[ptr++];
            }

            long nextLong() throws IOException {
                int c;
                do {
                    c = read();
                } while (c <= ' ' && c != -1);

                int sign = 1;
                if (c == '-') {
                    sign = -1;
                    c = read();
                }

                long val = 0;
                while (c > ' ') {
                    val = val * 10 + (c - '0');
                    c = read();
                }
                return val * sign;
            }

            int nextInt() throws IOException {
                return (int) nextLong();
            }
        }

        public static void main (String[]args) throws Exception {
            FastScanner fs = new FastScanner(System.in);
            StringBuilder out = new StringBuilder();

            int T = fs.nextInt();
            while (T-- > 0) {
                int n = fs.nextInt();

                long[] ti = new long[n];
                long[] di = new long[n];
                long[] li = new long[n];

                for (int i = 0; i < n; i++) {
                    ti[i] = fs.nextLong();
                    di[i] = fs.nextLong();
                    li[i] = fs.nextLong();
                }

                int total = 1 << n;
                long INF = Long.MAX_VALUE / 4;
                long[] dp = new long[total];
                Arrays.fill(dp, INF);
                dp[0] = 0L;

                for (int mask = 0; mask < total; mask++) {
                    if (dp[mask] == INF) continue;

                    for (int i = 0; i < n; i++) {
                        if ((mask & (1 << i)) != 0) continue; // i 已经降落过

                        long start = Math.max(dp[mask], ti[i]);
                        if (start <= ti[i] + di[i]) {
                            int nextMask = mask | (1 << i);
                            long finish = start + li[i];
                            if (finish < dp[nextMask]) {
                                dp[nextMask] = finish;
                            }
                        }
                    }
                }

                if (dp[total - 1] != INF) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            }

            System.out.print(out.toString());
        }
    }
/*
小蓝最近玩上了01游戏，这是一款带有二进制思想的棋子游戏，具体来说游戏在一个大小为N×N的棋盘上进行，
棋盘上每个位置都需要放置一位数字 0或者数字1，初始情况下，棋盘上有一部分位置已经被放置好了固定的数字，玩家不可以再进行更改。
玩家需要在其他所有的空白位置放置数字，并使得最终结果满足以下条件:
1. 所有的空白位置都需要放置一个数字 0/1;
2. 在水平或者垂直方向上，相同的数字不可以连续出现大于两次；
3. 每一行和每一列上，数字 0 和数字1的数量必须是相等的 (例如N = 4，则表示每一行/列中都需要有2 个 0和2个1);
4. 每一行都是唯一的，因此每一行都不会和另一行完全相同;同理每一列也都是唯一的，每一列都不会和另一列完全相同。
现在请你和小蓝一起解决 01游戏吧!题目保证所有的测试数据都拥有一个唯一的答案。
输入格式
输入的第一行包含一个整数N表示棋盘大小。
接下来 Ⅳ 行每行包含 Ⅳ 个字符，字符只可能是 0、1、-中的其中一个 (ASCIl 码分别为48，49，95)，
0表示这个位置数字固定为0，1表示这个位置数字固定为1，_ 表示这是一个空白位置，由玩家填充。
输出格式
输出 N 行每行包含 Ⅳ 个字符表示题目的解，其中的字符只能是0或者1。
 */