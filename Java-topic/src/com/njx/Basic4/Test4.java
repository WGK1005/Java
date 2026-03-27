package com.njx.Basic4;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt();
        while (t-->0) {
            long n = scan.nextLong();
            long m=scan.nextLong();
            long k= scan.nextLong();
            long r=k,l=k;
            int res=0;
            while (l<=n) {
                res+=r-l+1;
                if (l*m-m+2>n) {
                    break;
                }
                l=l*m-m+2;
                r=r*m+1;
            }
            if (r>n) {
                res-=r-n;
            }
            System.out.println(res);
        }
        scan.close();
    }
}
/*
给定一棵包含 n 个结点的完全 m叉树，结点按从根到叶、从左到右的顺序依次编号。例如下图是一个拥有 11 个结点的完全3 叉树。
你需要求出第k个结点对应的子树拥有的结点数量。
输入格式
输入包含多组询问。
输入的第一行包含一个整数T，表示询问次数。
接下来T 行，每行包含三个整数，m，k，表示一组询问。
输出格式
输出T行，每行包含一个整数表示对应询问的答案。
 */