package com.njx.Basic;

import java.util.*;
//这是正确率100的
public class Test8 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            long l = func(s);
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.reverse();
            for (int i = 0; i < stringBuilder.length(); ++i) {
                if (stringBuilder.charAt(i) == '(') {
                    stringBuilder.setCharAt(i, ')');
                }else {
                    stringBuilder.setCharAt(i, '(');
                }
            }
            long r = func(stringBuilder.toString());
            System.out.println((l * r) % MOD);
        }
    public static long func(String s) {
        int n = s.length();
        long[][] dp = new long[n+2][n+2];
        dp[0][0] = 1;//辅助初始化，同时也可以具有实际意义
        for (int i = 1; i <= n; ++i){
            if (s.charAt(i-1) == '(') {
                for (int j = 1; j <= n; ++j) {  //读入左括号，不可能出现左与右相等的情况，从1开始
                    dp[i][j] = dp[i-1][j-1];
                }
            }else {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;//dp[i][0]带公式越界，用原方法判定
                for (int j = 1; j <= n; ++j) {
                    dp[i][j] = (dp[i-1][j+1] + dp[i][j-1]) % MOD;
                }
            }
        }
        //从小往大括号数递增，第一个非零方案对应的状态就是最少括号数的”恰好“合法串
        for (int i = 0; i < n; ++i) {
            if (dp[n][i] != 0) return dp[n][i];
        }
        return -1;
    }
    }
 /*   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 读入括号字符串
        String s = sc.next();

        int n = s.length();

        /*
         * dp[l][r]：
         * 表示区间 [l, r] 变成合法括号串，最少需要添加多少个括号
         */
       /* int[][] dp = new int[n][n];

        /*
         * cnt[l][r]：
         * 表示在 dp[l][r] 最优（最少添加）的情况下，有多少种不同方案
         */
        //long[][] cnt = new long[n][n];

        // ================== 初始化 ==================
        //for (int i = 0; i < n; i++) {

            /*
             * 单个字符：
             * "(" → 需要补一个 ")"
             * ")" → 需要补一个 "("
             * 所以都需要添加 1 个括号
             */
          //  dp[i][i] = 1;

            /*
             * 只有一种补法：
             * "(" → "()"
             * ")" → "()"
             */
            //cnt[i][i] = 1;
        //}

        // ================== 区间DP ==================
        /*
         * 按区间长度枚举（从小区间推到大区间）
         */
        /*for (int len = 2; len <= n; len++) {

            /*
             * 枚举区间左端点
             */
          /*  for (int l = 0; l + len - 1 < n; l++) {

                int r = l + len - 1;

                // 初始化为极大值（后面要取最小）
                dp[l][r] = Integer.MAX_VALUE;

                // 方案数初始化为0
                cnt[l][r] = 0;

                // ================== 情况1：两端匹配 ==================
                /*
                 * 如果 s[l] 是 '(' 且 s[r] 是 ')'
                 * 可以尝试把这两个配成一对
                 */
          /*      if (s.charAt(l) == '(' && s.charAt(r) == ')') {

                    /*
                     * 中间区间 [l+1, r-1] 需要变合法
                     */
            //        int val;

                    // 如果中间还有区间
              //      if (l + 1 <= r - 1) {
                    //    val = dp[l + 1][r - 1];
                //    } else {
                        // 中间为空，不需要添加
                  //      val = 0;
                    //}

                    /*
                     * 对应方案数
                     */
               //     long ways;

                 /*   if (l + 1 <= r - 1) {
                        ways = cnt[l + 1][r - 1];
                    } else {
                        // 空区间方案数为1（什么都不做）
                        ways = 1;
                    }

                    /*
                     * 更新最优解
                     */
                   /* if (val < dp[l][r]) {

                        // 找到更优（更少添加）
                        dp[l][r] = val;

                        // 覆盖方案数
                        cnt[l][r] = ways;

                    } else if (val == dp[l][r]) {

                        // 同样最优 → 累加方案数
                        cnt[l][r] = (cnt[l][r] + ways) % MOD;
                    }
                }

                // ================== 情况2：区间分裂 ==================
                /*
                 * 把区间 [l, r] 分成：
                 * [l, k] + [k+1, r]
                 */
            /*    for (int k = l; k < r; k++) {

                    /*
                     * 左右区间分别变合法
                     */
              //      int val = dp[l][k] + dp[k + 1][r];

                    /*
                     * 方案数：
                     * 左区间方案 × 右区间方案
                     */
              //      long ways = (cnt[l][k] * cnt[k + 1][r]) % MOD;

                    /*
                     * 更新最优
                     */
                //    if (val < dp[l][r]) {

                /*        dp[l][r] = val;
                        cnt[l][r] = ways;

                    } else if (val == dp[l][r]) {

                        cnt[l][r] = (cnt[l][r] + ways) % MOD;
                    }
                }
            }
        }

        // 输出整个区间的方案数
        System.out.println(cnt[0][n - 1] % MOD);
    }
}*/
/*
给定一个括号序列，要求尽可能少地添加若干括号使得括号序列变得合法，当添加完成后，会产生不同的添加结果，请问有多少种本质不同的添加结果。
两个结果是本质不同的是指存在某个位置一个结果是左括号，而另一个是右括号。
例如，对于括号序列（（()，只需要添加两个括号就能让其合法,有以下几种不同的添加结果：0O0、0(O)、(O)0、(O0)和((O))。
输入描述
输入一行包含一个字符串 s，表示给定的括号序列，序列中只有左括号和右括号。
输出描述
输出一个整数表示答案，答案可能很大，请输出答案除以1000000007 (即 10°+ 7)的余数。
 */