package com.njx.Basic6;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //在此输入您的代码...
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n % 2 == 0) {
                int num = (k+1 <= n / 2) ? (k+1) : (n / 2);
                System.out.println(num);
            }
            else {
                int num = (k+1 <= n) ? (k+1) : (n);
                System.out.println(num);
            }
        }
        sc.close();
    }
}
/*
小蓝是小镇钟楼的管理员，负责维护一座古老的时钟。这座时钟的表盘上刻有从1到N的连续整数，初始时指针指向1。
平时，小蓝通过顺时针或逆时针拨动指针调整时间：顺时针拨动一次，指针从当前数字x移至x+1（若x=N，则移至1）；
逆时针拨动一次，指针从x移至x一1（若x =1，则移至 N)。
然而，一场突如其来的暴风雨损坏了钟楼。表盘因风沙侵蚀变得模糊不清，小蓝无法看清指针的当前位置；机械装置也因故障失灵，
导致他拨动指针时方向随机——可能是顺时针或逆时针，且拨动前无法预测方向。
小蓝记得暴风雨后他总共拨动了K次指针。为了确定指针的最终位置，他希望计算出经过这K次随机拨动后，指针最终可能指向的数字有多少个。
现在，请你帮助小蓝解决这个问题。
输入格式
输入的第一行包含一个整数T，表示测试用例的数量。
接下来T'行，每行包含两个整数N 和K，分别表示表盘上的数字个数和小蓝拨动指针的次数。
输出格式
输出共T行，每行包含一个整数，表示经过 K次随机拨动后，指针最终可能指向的不同数字的个数。
 */