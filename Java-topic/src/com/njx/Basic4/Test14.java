package com.njx.Basic4;

import java.util.*;

public class Test14 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=n/10;//每个数出现次数
        int aa[][]=new int[10][n];
        int index[]=new int[10];//统计每个数出现次数
        for (int i = 0; i < n; i++) {
            int x=scan.nextInt();
            aa[x][index[x]++]=scan.nextInt();//每次index[x]进行自增，方便下次赋值
        }
        int sum=0;//计代价
        for (int i = 0; i <10; i++) {
            Arrays.sort(aa[i],0,index[i]);//将数组进行从小到大的排序（升序排序）
            for(int j=0;j<index[i]-k;j++) {//如果一个数出现次数大于k则将大于k的次数的几个最小代价的累加（即转换为其他数字以达到所有数字相同的目的）
                sum+=aa[i][j];
            }
        }
        scan.close();
        System.out.println(sum);//输出
    }
}
/*
有一个长度为n的数组（n是 10的倍数），每个数ai都是区间[0，9中的整数。小明发现数组里每种数出现的次数不太平均，而更改第ⅸ个数的代价为bi，
他想更改若干个数的值使得这10种数出现的次数相等（都等于 l），请问代价和最少为多少。
输入格式
输入的第一行包含一个正整数n。
接下来n行，第i行包含两个整数ai，bi，用一个空格分隔。
输出格式
输出一行包含一个正整数表示答案。
 */