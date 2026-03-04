package com.njx.topic3;

import java.util.*;
//思路就是找最大相同字串，蓝桥无法通过，但是代码本身没有问题，大概是jdk的问题
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S=sc.nextLine();
        String T=sc.nextLine();

        int n=S.length();
        int m=T.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(S.charAt(i-1)==T.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                }
            }
        int count=m-dp[n][m];
        System.out.println(count);
        sc.close();
    }
}
