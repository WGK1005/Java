package com.njx.BaoLi;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans=0;
        for(int i = 1; i <= n; i++){
          if(check(i)){
              ans++;
          }
        }
        System.out.println(ans);

    }
    static boolean check(int x){

        int pos = 1;

        while(x > 0){

            int d = x % 10;

            if(pos % 2 == 1){ // 奇数位
                if(d % 2 == 0) return false;
            }else{            // 偶数位
                if(d % 2 == 1) return false;
            }

            x /= 10;
            pos++;
        }

        return true;
    }

}
/*
一个整数如果按从低位到高位的顺序，奇数位（个位、百位、万位···）上的数字是奇数，偶数位（十位、千位、十万位···）上的数字是偶数，我们就称之为“好数”。
给定一个正整数 N，请计算从 1到 N一共有多少个好数。
输入格式
一个整数IN。
输出格式
一个整数代表答案。
 */