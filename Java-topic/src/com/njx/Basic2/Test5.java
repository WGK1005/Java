package com.njx.Basic2;

import java.util.*;
import java.io.*;

public class Test5 {
    static int ans = 0;

    // 判断某个状态是否有五连
    static boolean win(int mask, int color) {
        // color = 1 表示白，0 表示黑

        for (int i = 0; i < 5; i++) {
            // 横
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                int pos = i * 5 + j;
                int c = ((mask >> pos) & 1);
                if (c == color) cnt++;
                else cnt = 0;
                if (cnt == 5) return true;
            }

            // 竖
            cnt = 0;
            for (int j = 0; j < 5; j++) {
                int pos = j * 5 + i;
                int c = ((mask >> pos) & 1);
                if (c == color) cnt++;
                else cnt = 0;
                if (cnt == 5) return true;
            }
        }

        // 主对角线
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int pos = i * 5 + i;
            int c = ((mask >> pos) & 1);
            if (c == color) cnt++;
            else cnt = 0;
        }
        if (cnt == 5) return true;

        // 副对角线
        cnt = 0;
        for (int i = 0; i < 5; i++) {
            int pos = i * 5 + (4 - i);
            int c = ((mask >> pos) & 1);
            if (c == color) cnt++;
            else cnt = 0;
        }
        if (cnt == 5) return true;

        return false;
    }

    public static void main(String[] args) {

        // 枚举所有 25位二进制
        for (int mask = 0; mask < (1 << 25); mask++) {

            // 剪枝：只要13个1（白棋）
            if (Integer.bitCount(mask) != 13) continue;

            // 如果有人赢了 → 不要
            if (win(mask, 1)) continue;
            if (win(mask, 0)) continue;

            ans++;
        }

        System.out.println(ans);
    }
}
/*

 */