package com.njx.topic3;

import java.util.*;
//约瑟夫环问题，主要公式为：(count+k)%i

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k= sc.nextInt();

        int count=0;
        for(int i=2;i<=n;i++){
            count =(count+k)%i;
        }
        System.out.println(count+1);
        sc.close();
    }
}
