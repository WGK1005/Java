package com.njx.topic3;
import java.util.*;
//调手表
//圆模型，最大距离即为d，主要公式是get函数，然后减去最大距离的n-1个数
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int d=get(n,k);
        System.out.println(n-d);
        sc.close();
    }
    static int get(int n,int m){
        return m==0?n:get(m,n%m);
    }
}
