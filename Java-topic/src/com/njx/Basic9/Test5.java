package com.njx.Basic9;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'){
                arr[i]=Character.toUpperCase(arr[i]);
            }
            System.out.print(arr[i]);
        }

    }
}
/*
元音变大写
 */