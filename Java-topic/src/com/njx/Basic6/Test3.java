package com.njx.Basic6;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        scan.nextLine();

        DateTimeFormatter ft= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //定义自定义格式
//        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTime=LocalDateTime.of(1970,1,1,0,0,0);
        //LocalDateTime.of()用于创建一个指定年月日时分秒的LocalDateTime对象

        for(int i=0;i<T;i++){
            String input=scan.nextLine();//读取输入
            String[] parts=input.split(" ");//将输入的字符串分为三部分
            String dateTimeStr=parts[0]+" "+parts[1];//1，2部分为时间
            int x=Integer.parseInt(parts[2]);//3部分为闹铃时间间隔

            LocalDateTime dateTime=LocalDateTime.parse(dateTimeStr,ft);//用format将字符串转为时间
            //LocalDateTime.parse()将字符串解析为LocalDateTime对象，需要指定格式
            long delteMin= java.time.Duration.between(startTime,dateTime).toMinutes();//获取总的时间间隔
            //Duration.between用于计算时间间隔，.toMinutes()转换为分钟数
            long n=delteMin/x;//求有多少个闹铃间隔时间x
            LocalDateTime result=startTime.plusMinutes(n*x);//结果为起始时间加上n个闹铃时间间隔
            //LocalDateTime.plusMinutes()加上指定分钟数，LocalDateTime.minusMinutes()减

            System.out.println(result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }
}
/*
小蓝正在和朋友们团建，有一个游戏项目需要两人合作，两个人分别拿到一棵大小为n和m的树，树上的每个结点上有一个正整数权值。
两个人需要从各自树的根结点1出发走向某个叶结点，从根到这个叶结点的路径上经过的所有结点上的权值构成了一个正整数序列，
两人的序列的最长公共前缀即为他们的得分。给出两棵树，请计算两个人最多的得分是多少。
输入格式
输入的第一行包含两个正整数n，m，用一个空格分隔。
第二行包含n个正整数C1，C2，··，Cn，相邻整数之间使用一个空格分隔，其中ci表示第一棵树结点i上的权值。
第三行包含m个正整数 d1， d2，…，dm，相邻整数之间使用一个空格分隔，其中di表示第二棵树结点i上的权值。
接下来n一1 行，每行包含两个正整数ui，vi表示第一棵树中包含一条ui和vi之间的边。
接下来m一1 行，每行包含两个正整数 pi，Qi 表示第二棵树中包含一条pi和qi之间的边。
输出格式
输出一行包含一个整数表示答案。
 */