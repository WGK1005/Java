package com.njx.Basic;

import java.util.*;

public class Test18 {
    //小蓝正在二维坐标系中构造正方形，他手上有n个正整数，他想知道有多少个有序四元组满足四个数不重复
    //且四个点：(0,0)、(-a1,a2)、(a3,a4)、(a3-a1,a2+a4)能构成一个正方形？
    //思路:只需要a1==a4 && a2==a3，便能确保组成的一定是正方形
    //先统计每个数的个数，然后找出大于等于2的数进行组合，统计共有多少种方案
    //统计个数我用的HashMap 然后再求值
    //求值时我是真无语了，调试了半天，一开始通过了11个案例，9个答案错误，后来挑了半天才
    //通过，主要原因是因为模的问题，一开始只给被除数的那些模了一次，后来我又给加完之后
    //的ans模了一次，还是不对，后来干脆直接把所有的数都模了一次，才通过了全部案例，真闹不
    //懂什么时候该模什么时候不用模
    public static void main(String[] args){
        long Mod = (long)1e9+7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for(int i = 0;i < n;i++){
            num[i] = scanner.nextInt();
        }

        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i < n;i++){
            //如果num[i]没有在HashMap中，那么就取0然后加1，如果存在就取原来的个数再加1
            m.put(num[i],m.getOrDefault(num[i],0)+1);
        }

        long ans = 0;
        for(Map.Entry<Integer,Integer> entry1: m.entrySet()){
            for(Map.Entry<Integer,Integer> entry2: m.entrySet()){
                if(entry1 == entry2 && entry1.getValue() >= 4){
                    ans += entry1.getValue() % Mod * (entry1.getValue()-1) % Mod * (entry1.getValue()-2) % Mod * (entry1.getValue()-3) % Mod;
                    ans %= Mod;
                }
                if(entry1 != entry2 && entry1.getValue() >= 2 && entry2.getValue() >= 2){
                    ans += entry1.getValue() % Mod * (entry1.getValue()-1) % Mod * entry2.getValue() % Mod * (entry2.getValue()-1) % Mod;
                    ans %= Mod;
                }
            }
        }

        System.out.println(ans);
    }
}
