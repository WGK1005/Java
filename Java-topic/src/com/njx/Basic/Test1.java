package com.njx.Basic;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for(int i = 0; i < n; i++){

            long x = sc.nextLong();

            if((x & (x - 1)) == 0){
                count++;
            }

        }

        System.out.println(count);
    }
}
/*
某日，小蓝静坐书桌前，目光所及，展现着 n 个数字，它们依次为 α1,α2,···,αn，熠熠生辉。小蓝悟到，如果一个数能够以若千个（至少两个）连续的正整数相加表示，那么它就蕴含诗意。例如，数字 6 就蕴含诗意， 因为它可以表示为 1 + 2 + 3。而 8则缺乏诗意，因为它无法用连续的正整数相加表示。
小蓝希望他面前的所有数字都蕴含诗意，为此，他决定从这n个数字中删除一部分。请问，小蓝需要删除多少个数字，才能使剩下的数字全部蕴含诗意？
输入格式
第一行包含一个整数n，表示展示的数字个数。
第二行包含n 个整数 α1,α2,···,αn，表示展示的数字。
输出格式
输出一个整数，表示小蓝需要删除的数字个数，以使剩下的数字全部蕴含诗意。
 */