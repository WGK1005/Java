package com.njx.Basic8;

import java.util.*;

public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> kinds = new HashSet<>();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int []b=new int[m];
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int s=a[i]+b[j];
                if(s<=n+m&&isPrime(s)){
                    kinds.add(s);
                }
            }
        }
        System.out.println(kinds.size());
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false; // 0和1不是质数

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
