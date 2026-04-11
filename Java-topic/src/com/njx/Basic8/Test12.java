package com.njx.Basic8;

import java.util.*;

public class Test12 {
    public static void main(String[] args) {
        int cnt = 0;
        for(int i = 2025; i <= 20250412; i++){
            int[] num = new int[10];
            int a = i;
            while(a != 0){
                num[a % 10]++;
                a /= 10;
            }
            if(num[0] >= 1 && num[2] >= 2 && num[5] >= 1) cnt++;
        }
        System.out.println(cnt);
    }
}
/*
求1～20250412 中，有多少个数可以通过改变其数字顺序后含有2025。
例如，5220、21520可以，而205、225、2200、222555111则不行。
提示：要求的数就是含有至少1个0、2个2、1个5的数。
 */