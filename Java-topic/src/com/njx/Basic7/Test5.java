package com.njx.Basic7;

import java.util.*;

public class Test5 {
    static final long MOD = 1000000007L;
    static final int N = 2025;

    static long solve(int k) {
        long dp0 = 1; // 当前是 k
        long dp1 = k; // 当前 < k

        for (int i = 2; i <= N; i++) {
            long new0 = (dp0 + dp1) % MOD;
            long new1 = (dp0 * k) % MOD;

            dp0 = new0;
            dp1 = new1;
        }

        return (dp0 + dp1) % MOD;
    }

    public static void main(String[] args) {
        long part3 = solve(4); // 3^4
        long part5 = solve(2); // 5^2

        long ans = (part3 * part5) % MOD;

        System.out.println(ans);
    }
}
/*
密码学家小蓝受邀参加国际密码学研讨会，为此他设计了一种新型锁，巧妙地融合了数学的严谨性与密码学的安全性。
这把锁包含 2025个连续的数字格，每个格子需填入一个止整数，从而形成一个长度为2025 的序列
{a1，a2，·，a2025}，其中ai表示第i个格子上的数字。
要想解锁，该序列需满足以下条件：任意两个相邻格子中的数字，其最小公倍数（LCM）均为2025。即对于所有的（1≤i≤2024)，需满定:
LCM(ai, ai+1) = 2025
现在，请你计算有多少个不同的序列能够解开这把锁。由于答案可能很大，你只需输出其对 10⁹+７ 取余后的结果即可。
 */