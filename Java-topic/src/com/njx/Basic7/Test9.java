package com.njx.Basic7;

import java.util.*;
//这有点太难了
public class Test9 {
    // 后缀自动机状态
    static class State {
        int[] next = new int[26];
        int link;
        int len;
        long occ; // 该状态对应 endpos 集合大小（出现次数）

        State() {
            Arrays.fill(next, -1);
            link = -1;
        }
    }

    static State[] st;
    static int size;
    static int last;

    static void samInit(int maxLen) {
        st = new State[maxLen * 2];
        for (int i = 0; i < st.length; i++) st[i] = new State();
        size = 1;
        last = 0;
        st[0].len = 0;
        st[0].link = -1;
    }

    static void extend(char ch) {
        int c = ch - 'a';
        int cur = size++;
        st[cur].len = st[last].len + 1;
        st[cur].occ = 1;

        int p = last;
        while (p != -1 && st[p].next[c] == -1) {
            st[p].next[c] = cur;
            p = st[p].link;
        }

        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next[c];
            if (st[p].len + 1 == st[q].len) {
                st[cur].link = q;
            } else {
                int clone = size++;
                st[clone].len = st[p].len + 1;
                st[clone].link = st[q].link;
                st[clone].occ = 0; // 克隆态不新增出现次数
                System.arraycopy(st[q].next, 0, st[clone].next, 0, 26);

                while (p != -1 && st[p].next[c] == q) {
                    st[p].next[c] = clone;
                    p = st[p].link;
                }
                st[q].link = clone;
                st[cur].link = clone;
            }
        }

        last = cur;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();

        samInit(n);
        for (int i = 0; i < n; i++) {
            extend(s.charAt(i));
        }

        // 按 len 计数排序，后续可按 len 降序回传 occ 到 suffix link
        int maxLen = 0;
        for (int i = 0; i < size; i++) maxLen = Math.max(maxLen, st[i].len);
        int[] cnt = new int[maxLen + 1];
        for (int i = 0; i < size; i++) cnt[st[i].len]++;
        for (int i = 1; i <= maxLen; i++) cnt[i] += cnt[i - 1];

        int[] order = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            order[--cnt[st[i].len]] = i;
        }

        // 降序累加出现次数
        for (int i = size - 1; i > 0; i--) {
            int v = order[i];
            int p = st[v].link;
            if (p >= 0) st[p].occ += st[v].occ;
        }

        long[] ans = new long[n + 1];
        // 每个状态贡献 len(link(v))+1 .. len(v) 这些不同长度的子串，且出现次数都为 occ[v]
        for (int v = 1; v < size; v++) {
            long occ = st[v].occ;
            if (occ >= 1 && occ <= n) {
                int l = st[st[v].link].len + 1;
                int r = st[v].len;
                ans[(int) occ] += (long) (r - l + 1);
            }
        }

        StringBuilder out = new StringBuilder();
        for (int k = 1; k <= n; k++) {
            out.append(ans[k]).append('\n');
        }
        System.out.print(out);
    }
}
/*
给定一个仅含小写英文字母组成的字符串S，问有多少个不同的字符串在S中出现1∼S|次。当两个字符串的长度或任意位置的字符不同时，我们认为这两个字符串是不同的。
输入格式
输入一行包含一个字符串S，由小写英文字母组成。
输出格式
输出|S|行，每行包含一个整数，其中第行的整数表示在S|中正好出现次的字符串的数量。
 */