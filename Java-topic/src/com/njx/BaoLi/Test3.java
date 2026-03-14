package com.njx.BaoLi;

import java.util.*;

public class Test3 {
    static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    static boolean isLeap(int y){
        return (y%4==0 && y%100!=0) || (y%400==0);
    }

    static boolean check(int y,int m,int d){

        if(m < 1 || m > 12) return false;

        int day = days[m];

        if(m == 2 && isLeap(y)) day = 29;

        if(d < 1 || d > day) return false;

        if(y < 1960 || y > 2059) return false;

        return true;
    }

    static int getYear(int y){
        if(y >= 60) return 1900 + y;
        else return 2000 + y;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String[] t = s.split("/");

        int A = Integer.parseInt(t[0]);
        int B = Integer.parseInt(t[1]);
        int C = Integer.parseInt(t[2]);

        TreeSet<String> set = new TreeSet<>();

        // 年/月/日
        int y = getYear(A);
        if(check(y,B,C)){
            set.add(String.format("%04d-%02d-%02d",y,B,C));
        }

        // 月/日/年
        y = getYear(C);
        if(check(y,A,B)){
            set.add(String.format("%04d-%02d-%02d",y,A,B));
        }

        // 日/月/年
        y = getYear(C);
        if(check(y,B,A)){
            set.add(String.format("%04d-%02d-%02d",y,B,A));
        }

        for(String x:set){
            System.out.println(x);
        }
    }
}
/*
小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在1960年1 月1 日至2059年12月31日。令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。
比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？
输入描述
一个日期， 格式是"AA/BB/CC"(0 ≤ A, B,C≤ 9)。
输出描述
输出若干个不相同的日期，每个日期一行，格式是“yyyy一M M － dd"。多个日期按从早到晚排列。
 */