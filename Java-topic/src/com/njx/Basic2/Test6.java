package com.njx.Basic2;

import java.util.*;
import java.io.*;

public class Test6 {
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 子区间数量最多 n(n+1)/2 ≈ 500000
        long[] check = new long[n * (n + 1) / 2 + 5];

        int idx = 0;

        // 枚举所有子区间和
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = i; j <= n; j++) {
                sum += a[j];
                check[++idx] = sum;
            }
        }

        // 排序
        Arrays.sort(check, 1, idx + 1);

        long ans = Long.MAX_VALUE;

        // 找最小差值
        for (int i = 2; i <= idx; i++) {
            ans = Math.min(ans, check[i] - check[i - 1]);
        }

        System.out.println(ans);
    }
}
