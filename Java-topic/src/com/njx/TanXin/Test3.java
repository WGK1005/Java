package com.njx.TanXin;

import java.util.*;

public class Test3 {
    public static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long  N = sc.nextLong();

        int ma=sc.nextInt();
        long []A=new long[ma];
        for(int i = 0; i < ma; i++)
        {
            A[i]=sc.nextLong();
        }
        int mb=sc.nextInt();
        long []B=new long[mb];
        for(int i = 0; i < mb; i++)
        {
            B[i]=sc.nextLong();
        }
        // 统一长度（从低位对齐）
        int maxLen = Math.max(ma, mb);

        long[] a = new long[maxLen];
        long[] b = new long[maxLen];

        // 倒着填充（方便从低位开始算）
        for(int i = 0; i < ma; i++){
            a[i] = A[ma - 1 - i];
        }
        for(int i = 0; i < mb; i++){
            b[i] = B[mb - 1 - i];
        }

        long weight = 1;  // 当前权值
        long ans = 0;

        for(int i = 0; i < maxLen; i++){

            long maxDigit = Math.max(a[i], b[i]);

            // 当前位最小合法进制
            long base = Math.max(2, maxDigit + 1);

            if(base > N){
                System.out.println(-1);
                return;
            }

            // 累加贡献
            long diff = (a[i] - b[i]) % MOD;
            ans = (ans + diff * weight % MOD) % MOD;

            // 更新权值
            weight = weight * base % MOD;
        }

        // 防止负数
        ans = (ans + MOD) % MOD;

        System.out.println(ans);
    }
}
/*
X 进制是一种很神奇的进制，因为其每一数位的进制并不固定！例如说某种 X 进制数，最低数位为二进制，第二数位为十进制，
第三数位为八进制,则 X 进制数 321 转换为十进制数为 65 。
现在有两个 X 进制表示的整数 A 和 B，但是其具体每一数位的进制还不确定，只知道 A 和 B 是同一进制规则，且每一数位最高为 N 进制,最低为二进 制。 请你算出 A － B 的结果最小可能是多少。
请注意,你需要保证 A 和 B 在 X 进制下都是合法的,即每一数位上的数字要小于其进制。
输入格式
第一行一个止整数N，含义如题面所述。
第二行一个正整数Ma，表示X 进制数A 的位数。
第三行 M。个用空格分开的整数，表示 X 进制数A 按从高位到低位顺序各个数位上的数字在十进制下的表示。
第四行一个正整数Mb，表示X 进制数B的位数。
第五行M个用空格分开的整数，表示X 进制数B按从高位到低位顺序各个数位上的数字在十进制下的表示。
请注意，输入中的所有数字都是十进制的。
输出格式
输出一行一个整数,表示 X 进制数 A － B 的结果的最小可能值转换为十进制后再模1000000007的结果。
 */