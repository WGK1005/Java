package com.njx.qianZhuiHe;

import java.util.*;

public class Test10 {
    public static void main(String[] args) {

        // 创建输入对象，用来读取输入数据
        Scanner sc = new Scanner(System.in);

        // 读取线段数量 n
        int n = sc.nextInt();

        // 读取查询区间数量 m
        int m = sc.nextInt();

        // 定义数组存储每条线段的中点
        double[] mid = new double[n];

        // 读取每条线段
        for(int i = 0; i < n; i++){

            // 左端点
            int l = sc.nextInt();

            // 右端点
            int r = sc.nextInt();

            // 计算线段的中点
            // 中点 = (l + r) / 2
            mid[i] = (l + r) / 2.0;
        }

        // 对所有中点进行排序
        // 排序后方便用二分查找
        Arrays.sort(mid);

        // 处理每一个查询区间
        for(int i = 0; i < m; i++){

            // 查询区间左端点
            int L = sc.nextInt();

            // 查询区间右端点
            int R = sc.nextInt();

            // 找到第一个 ≥ L 的中点位置
            int left = lower(mid , L);

            // 找到第一个 > R 的中点位置
            int right = upper(mid , R);

            // 区间内中点数量
            // = right - left
            System.out.println(right - left);
        }
    }

    // 二分查找：寻找第一个 ≥ x 的位置
    static int lower(double[] a , double x){

        int l = 0;
        int r = a.length;

        while(l < r){

            int mid = (l + r) / 2;

            // 如果当前值 ≥ x
            // 说明答案可能在左边
            if(a[mid] >= x){
                r = mid;
            }
            else{
                // 否则继续向右找
                l = mid + 1;
            }
        }

        // 返回第一个 ≥ x 的位置
        return l;
    }

    // 二分查找：寻找第一个 > x 的位置
    static int upper(double[] a , double x){

        int l = 0;
        int r = a.length;

        while(l < r){

            int mid = (l + r) / 2;

            // 如果当前值 > x
            if(a[mid] > x){
                r = mid;
            }
            else{
                // 否则继续向右
                l = mid + 1;
            }
        }

        // 返回第一个 > x 的位置
        return l;
    }
}
/*
小明拿了  条线段练习抓娃娃。他将所有线段铺在数轴上，第讠条线段的左端点在l，右端点在r。小明用m个区间去框这些线段，第个区间的范围是[L，R]。如果一个线段有至少一半的长度被包含在某个区间内，则将其视为被这个区间框住。请计算出每个区间框住了多少个线段？
输入格式
输入共n + m + 1 行。
第一行为两个正整数n,m。后面n 行，每行两个整数l,r。后面m 行，每行两个整数L，R。
输出格式
输出共m 行，每行一个整数。
 */