package com.njx.Basic5;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cout=0;
        for(int i=1;i<100000001;i++){
            String  s="";
            s=i+"";
            if (s.length()%2==0){
                char[] chars = s.toCharArray();
                int q=s.length()/2;
                int sum=0,sum1=0;
                for(int j=0;j<q;j++){
                    sum+= Integer.parseInt(String.valueOf(chars[j]));
                }
                for(int k=q;k<chars.length;k++){
                    sum1+=Integer.parseInt(String.valueOf(chars[k]));
                }

                if(sum==sum1){
                    cout++;
                }
            }
        }
        System.out.print(cout);
        scan.close();
    }
}
