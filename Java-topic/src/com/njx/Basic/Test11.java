package com.njx.Basic;

import java.util.*;
import java.math.BigInteger;

//这么写算是暴力虽然有biginteger但是还是存在溢出的问题，目前没有更好的方法，所以通过率60也还好。
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        BigInteger a = BigInteger.ZERO;  // 当前 a[i]
        BigInteger sum = BigInteger.ZERO; // 总和

        for (int i = 1; i <= n; i++) {

            // a[i] = a[i-1] * 10 + 6
            a = a.multiply(BigInteger.TEN).add(BigInteger.valueOf(6));

            // b[i] = a[i]^2
            BigInteger b = a.multiply(a);

            // 累加
            sum = sum.add(b);
        }

        System.out.println(sum);
    }
}
