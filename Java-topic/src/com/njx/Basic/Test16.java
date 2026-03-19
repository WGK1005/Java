package com.njx.Basic;

import java.util.*;

public class Test16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入表达式 (例：3+5):");
        String input = scanner.nextLine();

        String[] parts = input.split("(?<=[-+*/%])|(?=[-+*/%])");

        if (parts.length != 3) {
            System.out.println("输入格式错误！");
            return;
        }

        double num1 = Double.parseDouble(parts[0].trim());
        String operator = parts[1].trim();
        double num2 = Double.parseDouble(parts[2].trim());

        double result = 0;
        char op = operator.charAt(0);

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("错误：除数不能为零！");
                    return;
                }
                result = num1 / num2;
                break;
            case '%':
                if (num2 == 0) {
                    System.out.println("错误：取模的除数不能为零！");
                    return;
                }
                result = num1 % num2;
                break;
            default:
                System.out.println("错误：不支持的运算符 " + op);
                return;
        }

        System.out.println(num1 + " " + op + " " + num2 + " = " + result);

        scanner.close();
    }
}
