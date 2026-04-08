package com.njx.Basic8;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        int[] score = {5, 10, 15, 20, 25};

        HashSet<Integer> set = new HashSet<>();
        set.add(0); // 初始：什么都不选

        for (int s : score) {
            HashSet<Integer> next = new HashSet<>(set);

            for (int cur : set) {
                // 选1次
                next.add(cur + s);

                // 选2次
                next.add(cur + 2 * s);
            }

            set = next;
        }

        System.out.println(set.size());
    }
}
/*
在今年蓝桥杯的决赛中，一共有 10 道题目，每道题目的分数依次为5分，5分，10分，10分，15分，15分，20分，20分，25分，25分。
假设某位参赛选手在解答每一道题时，要么能得到该题的全部分数，要么就得0分。
那么请问，这位参赛选手在完成这10 道题之后，所能获得的总分值存在多少种不同的情况?
注意，总分值仅需关注选手10 道题的总得分，而无需关注具体是由哪些题获得了相应的分数。
例如，选手第一道题获得5分其余题均为0分，与第二道题获得5分其余题均为0分，应视为同一种情况。
 */