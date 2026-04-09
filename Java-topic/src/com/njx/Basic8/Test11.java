package com.njx.Basic8;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        int result = 0;

        while (count < 2025) {
            if (isPrime(number)) {
                count++;
                result = number;
            }
            number++;
        }

        System.out.println("第2025个质数是: " + result);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;


    }
}
/*
如果一个正整数只能被１ 和它本身整除，就称为一个质数。最小的几个质数依次是2，3，5，7，11，13，……
请问，第2025个质数是多少？
 */