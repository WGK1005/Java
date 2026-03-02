package com.njx.topic3;
import java.util.*;
//买不到的数目

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        if(get(n,m)!=1){
            System.out.println(-1);
        }else{
            System.out.println(n*m-n-m);
        }

    }
    static int get(int n,int m){
        return m==0?n:get(m,n%m);
    }

}
//重点是一个公式n*m-n-m这就是找买不到数目最大值的公式