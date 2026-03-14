package com.njx.topic1;

import java.util.Scanner;

/**
 * 两位数逆序输出
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入一个两位数：");
        int num = scanner.nextInt();
        
        // 获取个位数字
        int geWei = num % 10;
        
        // 获取十位数字
        int shiWei = num / 10;
        
        // 计算逆序数
        int reverseNum = geWei * 10 + shiWei;
        
        System.out.println("该数的逆序数是：" + reverseNum);
        
        scanner.close();
    }
}
