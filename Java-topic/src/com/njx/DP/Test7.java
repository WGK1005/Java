package com.njx.DP;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++){

            if(i == 1 || i == N){
                System.out.println(N - 1);
            }else{
                int h = Math.max(2*(i-1), 2*(N-i));
                System.out.println(h);
            }

        }
    }
}
/*

 */