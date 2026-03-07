package com.njx.qianZhuiHe;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = 20230610;

        long h = 1;

        while(true){

            long s = h*(h+1)*(h+2)/6;

            if(s > n){
                System.out.println(h-1);
                break;
            }

            h++;
        }
    }
}
/*
*小蓝有 20230610 颗磁力弹珠，他对金字塔形状尤其感兴趣，如下图所示：
高度为 1 的金字塔需要 1 颗弹珠;高度为 2 的金字塔需要 4 颗弹珠;高度为3 的金字塔需要10颗弹珠;高度为 4 的金字塔需要 20 颗弹珠。
小蓝想要知道用他手里的弹珠可以摆出的最高的金字塔的高度是
 */
