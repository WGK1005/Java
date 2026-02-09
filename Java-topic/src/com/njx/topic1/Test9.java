package com.njx.topic1;
import java.util.*;
public class Test9 {
    public static void main(String[] args) {
        //乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊 C 型饮料，凭 3 个瓶盖可以再换一瓶 C 型饮料，并且可以一直循环下去(但不允许暂借或赊账)。
        //请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的 n 瓶饮料，最后他一共能喝到多少瓶饮料。
        //输入描述
        //输入一个整数n(0<n<1000)，表示开始购买的饮料数量。
        //输出描述
        //输出一个整数，表示实际得到的饮料数
        //简单
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 初始购买的饮料数
        int total = n;          // 总共喝到的饮料数
        int caps = n;           // 当前瓶盖数

        // 只要还能兑换
        while (caps >= 3) {
            int exchange = caps / 3; // 本轮能换几瓶
            total += exchange;       // 喝掉这些
            caps = caps % 3 + exchange; // 剩余瓶盖 + 新瓶盖
        }

        System.out.println(total);
        sc.close();
    }
}
