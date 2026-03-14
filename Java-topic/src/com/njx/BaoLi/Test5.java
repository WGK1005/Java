package com.njx.BaoLi;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int[] cnt = new int[26];

        // 统计次数
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){

            if(cnt[i] > 0){
                max = Math.max(max, cnt[i]);
                min = Math.min(min, cnt[i]);
            }

        }

        System.out.println(max - min);
    }
}
/*
x 星球有 26 只球队，分别用 a ~ z 的 26 个字母代表。 他们总是不停地比赛。
在某一赛段，哪个球队获胜了，就记录下代表它的字母，这样就形成一个长长的串。
国王总是询问：获胜次数最多的和获胜次数最少的有多大差距？(当然，他不关心那些一次也没获胜的，认为他们在怠工罢了)
输入描述
输入，一个串，表示球队获胜情况（保证串的长度<1000）。
输出描述
要求输出一个数字，表示出现次数最多的字母比出现次数最少的字母多了多少次。
 */