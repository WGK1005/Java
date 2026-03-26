package com.njx.Basic4;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int year = 1900; //年
        int mon = 1; //月
        int day = 1; //日
        int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int count = 0;
        while (true) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) { //先判断是否为闰年
                month[2] = 29; //是的话2月有29天
            } else {
                month[2] = 28; //不是的话2月有28天，一定要加这个else，否则闰年过后2月还是29天，没改回来
            }
            if (year / 1000 + year / 100 % 10 + year / 10 % 10 + year % 10 == mon % 10 + mon / 10 + day % 10
                    + day / 10) { //把年份的每一位拆解，月份和天也拆解，判断是否数位相加之后相等
                count++;
            }
            day++;
            if (day > month[mon]) { //如果天数大于这个月的具体天数，则天数归1，月份+1
                day = 1;
                mon++;
                if (mon > 12) { //月份如果大于了12，就表示该进入下一年，月份归1，年份+1
                    mon = 1;
                    year++;
                }
            }
            if (year == 9999 && mon == 12 && day == 31) { //到这个日期停止，手动算一下这天不符合题目要求，就直接跳出while循环
                break;
            }
        }
        System.out.println(count); //输出结果
    }
}
/*
对于一个日期，我们可以计算出年份的各个数位上的数字之和，也可以分别计算月和日的各位数字之和。请问从 1900 年1 月1日至9999 年12 月 31 日，总共有多少天，年份的数位数字之和等于月的数位数字之和加日的数位数字之和。
例如，2022 年 11 月 13 日满足要求，因为 2 + 0 + 2 +2 =(1+1)+(1 +3)。
请提交满足条件的日期的总数量。
 */