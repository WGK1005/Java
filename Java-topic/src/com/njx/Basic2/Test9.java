package com.njx.Basic2;

import java.util.*;
import java.io.*;
//累了，通过率80
public class Test9 {
    static class FastReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static List<Character> getUnique(String s, int l, int r) {
        boolean[] vis = new boolean[26];
        List<Character> res = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            if (!vis[c - 'a']) {
                vis[c - 'a'] = true;
                res.add(c);
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();

        String s = in.next();
        int m = in.nextInt();
        StringBuilder out = new StringBuilder();

        while (m-- > 0) {
            int la = in.nextInt() - 1;
            int ra = in.nextInt() - 1;
            int lb = in.nextInt() - 1;
            int rb = in.nextInt() - 1;

            List<Character> A = getUnique(s, la, ra);
            List<Character> B = getUnique(s, lb, rb);

            int len = Math.min(A.size(), B.size());
            int ans = 0;

            for (int i = 0; i < len; i++) {
                if (A.get(i) != B.get(i)) ans++;
            }

            ans += Math.abs(A.size() - B.size());
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
/*
给定一个字符串S以及若干组询问，每个询问包含两个区间(La,Ra),(Lb,Rb)，你需要判定 SLa,SLa+1,···,SRa与 SLb，SLb+1,···，SR,去重后有多少个位置上的字符是不同的。
这里的去重指的是每个子串对于每种字符，只保留第一个出现的那个，后续出现的直接丢弃。
例如 aabcbac 在选中区间(1,5)时，得到子串 αabcb，去重后为 abc，选中区间(3,6）时得到 bcba，去重后为 bca
特别地，两个长度不同的子串中，较长串的多出的部分每个位置都视为不同。
输入格式
输入第一行包含一个字符串S。
第二行包含一个整数m，表示询问次数。
接下来m行，每行包含四个整数，表示一次询问。
输出格式
输出共m行，每行一个整数对应每次询问的答案。
 */