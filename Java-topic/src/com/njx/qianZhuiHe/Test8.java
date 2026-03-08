package com.njx.qianZhuiHe;

import java.util.*;
//完全通过版。二分加前缀和
public class Test8 {
    static int N;
    static int[] a;
    static int[] b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);

        for (int i = 0; i <N; i++) {
            int l = a[i];
            int r = (int)1e9;
            int ans = a[i];

            while(l <= r){

                int mid = l + (r - l) / 2;

                if(check(mid, a[i])){
                    ans = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }

            System.out.print(ans - a[i] + (i == N - 1 ? "" : " "));
        }
        System.out.println();
        sc.close();
    }

    static boolean check(int x, int self){

        int less = lowerBound(x);
        int more = N - upperBound(x);

        // 去掉自己原来的贡献
        if(self < x) less--;
        if(self > x) more--;

        return more <= less;
    }

    static int lowerBound(int x){

        int l = 0, r = N;

        while(l < r){
            int mid = (l + r) / 2;

            if(b[mid] >= x) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    static int upperBound(int x){

        int l = 0, r = N;

        while(l < r){
            int mid = (l + r) / 2;

            if(b[mid] > x) r = mid;
            else l = mid + 1;
        }

        return l;
    }
}

/**
 * 小蓝老师教的编程课有 N 名学生,编号依次是 1．.. N。第 号学生这学期刷题的数量是A。
 * 对于每一名学生，请你计算他至少还要再刷多少道题，才能使得全班刷题比他多的学生数不超过刷题比他少的学生数。
 * 输入格式
 * 第一行包含一个正整数N。
 * 第二行包含N个整数:A1,A2,A3,···,AN
 * 输出格式
 * 输出N个整数，依次表示第1...N号学生分别至少还要再刷多少道题。
 */


//无法完全通过
/*public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];
        int[] b= new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);
        int target = b[N/2];
        for (int i = 0; i < N; i++) {
            if(a[i] >= target)
                System.out.print(0 + " ");
            else
                System.out.print(b[N/2] - a[i] + " ");
        }
    }
}
*/