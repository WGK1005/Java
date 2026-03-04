package com.njx.topic3;

import java.util.*;

public class Test8 {
    public static void main(String[] args) {
        int[] digits={1,2,3,4};
        List< Integer>  list=new ArrayList<>();

        for(int a: digits)
        {
            for(int b: digits)
            {
                if(a==b)
                {
                    continue;
                }
                for(int c: digits)
                {
                    if(c==a||c==b)
                    {
                        continue;
                    }
                    list.add(a*100+b*10+c);

                }
            }
        }
        System.out.println("共有" +list.size()+"个三位数");
        System.out.println( list);
    }
}
