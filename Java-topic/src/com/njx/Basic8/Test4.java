package com.njx.Basic8;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        String s="kfdhtshmrw4nxg#f44ehlbn33ccto#mwfn2waebry#3qd1ubwyhcyuavuajb#vyecsycuzsmwp31ipzah#catatja3kaqbcss2th";

        int res=0;
        for (int len = 8; len <= 16; len++) {
            for (int l = 0; l+len-1 < s.length(); l++) {
                int r=l+len;
                String sub = s.substring(l, r);
                boolean hasNum=false,hasSign=false;
                char[] chars = sub.toCharArray();
                for (char c : chars) {
                    if (c >= '0' && c <= '9') hasNum = true;
                    else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) hasSign = true;
                }
                if(hasSign&&hasNum) res++;
            }
        }
        System.out.println(res);
    }
}
