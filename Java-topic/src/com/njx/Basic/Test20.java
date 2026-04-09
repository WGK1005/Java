package com.njx.Basic;

public class Test20 {
    public static void main(String[] args) {
        int count = 0; // 记录找到的质数个数
        int number = 2; // 从2开始检查
        int result = 0; // 存储第2025个质数
        
        while (count < 2025) {
            if (isPrime(number)) {
                count++;
                result = number;
            }
            number++;
        }
        
        System.out.println("第2025个质数是: " + result);
    }
    
    /**
     * 判断一个数是否为质数
     * @param n 待判断的数
     * @return 如果是质数返回true，否则返回false
     */
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
        // 只需要检查到sqrt(n)即可
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
