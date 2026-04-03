package com.njx.Basic7;

import java.util.*;
import java.time.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int m = scan.nextInt();
        int d1 = scan.nextInt();
        int n =  scan.nextInt();
        int d2 = scan.nextInt();
        int k = scan.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 2025; i < 2025+k; i++) {
            int curD1 = d1;
            int curD2 = d2;
            boolean leap = Year.isLeap(i);
            if (m == 2 && d1 == 29 && !leap) {
                curD1 = 28;
            }

            if (n == 2 && d2 == 29 && !leap) {
                curD2 = 28;
            }

            LocalDate date1 = LocalDate.of(i, m, curD1);
            LocalDate date2 = LocalDate.of(i, n, curD2);

            if (date1.getDayOfWeek() == date2.getDayOfWeek()) {
                res.add(i);
            }
        }
        if (res.isEmpty()) {
            System.out.println("No Answer");
        } else {
            for (int i : res) {
                System.out.println(i);
            }
        }
        scan.close();
    }
}
/*
小蓝和小乔是好朋友，他们想知道在未来的日子里，什么时候他们的生日会在同一个星期几。
已知小蓝的生日是m月d1日，小乔的生日是n月d2日，请你计算从今年开始（今年为2025 年），未来k年内（包括今年，即年份在区间2025，2025十k中），他们生日在同一个星期几的年份有哪些。
提示:
• 闰年的判断规则为：年份能被4整除但不能被100整除，或能被 400 整除。闰年的 2 月有 29 天，非闰年的2月有28天。
• 如果某人的生日是2月29日，那么在非润年中，他/她的生日将被视为2月28日进行计算。
• 保证输入日期均为合法日期。
输入格式
输入一行包含五个正整数m,d1，n，d2，k，相邻整数之间使用一个空格分隔。
输出格式
输出若干行，每行包含一个整数，表示小蓝和小乔生日在同一个星期几的年份（从今年开始计算，按照年份从小到大的顺序输出）。
如果在未来k年内没有这样的年份，输出英文No Answer。
 */