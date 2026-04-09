package com.njx.Basic8;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result=0;
        for(int i=1;i<=202504;i++){
            int sum=0;
            int num=i;
            while(num>0){
                int ge=num%10;
                sum+=ge;
                num/=10;
            }
            if(sum%5==0){
                result++;
            }
        }
        System.out.println(result);
        scan.close();
    }
}
/*
请问在1至202504（含）中，有多少个数的各个数位之和是5的整数倍。
例如：5、19、8025都是这样的数。
 */