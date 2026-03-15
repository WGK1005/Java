package com.njx.BaoLi;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {
                int []day={0,31,28,31,30,31,30,31,31,30,31,30,31};
                int []arr={5, 6, 8, 6, 9, 1, 6, 1, 2, 4, 9, 1, 9, 8, 2, 3, 6, 4, 7, 7, 5, 9, 5, 0, 3, 8, 7, 5, 8, 1, 5, 8, 6, 1, 8, 3, 0, 3, 7, 9, 2,
                        7, 0, 5, 8, 8, 5, 7, 0, 9, 9, 1, 9, 4, 4, 6, 8, 6, 3, 3, 8, 5, 1, 6, 3, 4, 6, 7, 0, 7, 8, 2, 7, 6, 8, 9, 5, 6, 5, 6, 1, 4, 0, 1,
                        0, 0, 9, 4, 8, 0, 9, 1, 2, 8, 5, 0, 2, 5, 3, 3};
                int []date={2,0,2,3,0,0,0,0};
                int count=0;
                for(int i=1; i<=12; i++){
                    if(i<10){
                        date[4] = i / 10;
                        date[5] = i % 10;
                    }else{
                        date[4] = i / 10 % 10;
                        date[5] = i % 10;
                    }
                    for(int j=1; j<=day[i]; j++){
                        if(j<10){
                            date[6] = j / 10;
                            date[7] = j % 10;
                        }else{
                            date[6] = j /10 % 10;
                            date[7] = j %10;
                        }
                        if(check(date,arr)){
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
            public static boolean check(int[] date, int[] arr){
                int dIndex = 0;
                int aIndex = 0;
                while(dIndex<8 && aIndex<100){
                    if(date[dIndex]==arr[aIndex]){
                        dIndex++;
                        aIndex++;
                    }else{
                        aIndex++;
                    }
                }
                return dIndex==8?true:false;
            }
        }


/*

 */
