package com.njx.Basic;

import java.util.*;

//以下是题解中运用队列的方法，比较新颖，而且不超时
public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mins = new int[n];
        int[] record = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        LinkedList<Integer> qmin = new LinkedList<Integer>();

        //初始化双端队列， 小->大
        //
        for (int i = 0; i <= k; i++) {
            //有更小的进入队列时，大的从队尾弹出,
            while (!qmin.isEmpty() && i<n && arr[qmin.peekLast()] >= arr[i]) {
                qmin.pollLast();
            }
            // 进入队列
            qmin.addLast(i);
        }
        mins[0] = arr[qmin.peekFirst()];

        for (int i = 1; i < n; i++) { //窗口每次向后滑动一格
            if(!qmin.isEmpty() && i-k>=0 && qmin.peekFirst()<i-k){ // 超出当前窗口左边界的需要弹出队列,队头需要弹出
                qmin.pollFirst();
            }
            //有更小的进入队列时，大的从队尾弹出,
            while (!qmin.isEmpty() && i+k<n && arr[qmin.peekLast()] >= arr[i+k]) {
                qmin.pollLast();
            }

            if(i+k<n){
                qmin.addLast(i+k);
            }
            mins[i]=arr[qmin.peekFirst()];
        }

        for (int i = 0; i != mins.length; i++) {
            System.out.print(mins[i] + " ");
        }
    }
}
//这是一个滑动窗口题，但是用经典的模板就是下面的通过率只有80，我需要找找原因
/*public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(n - 1, i + k);
            int minVal = a[left];
            for (int j = left + 1; j <= right; j++) {
                if (a[j] < minVal) {
                    minVal = a[j];
                }
            }
            result[i] = minVal;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
/*
小蓝有—个序列 a[1],a[2],.., a[n]。
给定一个正整数 k，请问对于每一个 1 到 n 之间的序号 ,a[ - k],a[- k + 1],,a[ + k] 这 2k + 1 个数中的最小值是多少？
当某个下标超过 1 到 n 的范围时，数不存在，求最小值时只取存在的那些值。
输入格式
输入的第一行包含一整数n。
第二行包含 n 个整数，分别表示 α[1],α[2],.,a[n]。
第三行包含一个整数k。
输出格式
输出一行，包含n个整数，分别表示对于每个序号求得的最小值。
 */