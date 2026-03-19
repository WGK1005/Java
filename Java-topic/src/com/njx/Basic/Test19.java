package com.njx.Basic;

import java.util.*;

public class Test19 {
    static long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }

        sc.close();
    }

    private static long solve(int n) {
        if (n < 3) {
            return 0;
        }

        long totalLiars = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (check(mask, n)) {
                int liars = countLiars(mask, n);
                totalLiars = (totalLiars + liars) % MOD;
            }
        }

        return totalLiars;
    }

    private static boolean check(int mask, int n) {
        for (int i = 0; i < n; i++) {
            boolean iTruth = (mask & (1 << i)) != 0;
            boolean i1Truth = (mask & (1 << ((i + 1) % n))) != 0;
            boolean i2Truth = (mask & (1 << ((i + 2) % n))) != 0;

            boolean statement = (i1Truth && !i2Truth) || (!i1Truth && i2Truth);

            if (iTruth != statement) {
                return false;
            }
        }
        return true;
    }

    private static int countLiars(int mask, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                count++;
            }
        }
        return count;
    }
}
