package com.njx.qianZhuiHe;

import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] L = new int[m+1];
        int[] R = new int[m+1];

        int[] diff = new int[n+2];

        // 读入操作并做差分
        for(int i=1;i<=m;i++){
            L[i] = sc.nextInt();
            R[i] = sc.nextInt();

            diff[L[i]]++;
            diff[R[i]+1]--;
        }

        int[] a = new int[n+1];

        // 恢复库存
        for(int i=1;i<=n;i++){
            a[i] = a[i-1] + diff[i];
        }

        // 原本库存为0的商品
        int baseZero = 0;

        // 前缀统计 a[i]==1
        int[] pre = new int[n+1];

        for(int i=1;i<=n;i++){

            if(a[i]==0) baseZero++;

            pre[i] = pre[i-1];

            if(a[i]==1) pre[i]++;
        }

        // 计算每个操作的答案
        for(int i=1;i<=m;i++){

            int countOne = pre[R[i]] - pre[L[i]-1];

            int ans = baseZero + countOne;

            System.out.println(ans);
        }
    }
}
/*
在库存管理系统中，跟踪和调节商品库存量是关键任务之一。小蓝经营的仓库中存有多种商品，这些商品根据类别和规格被有序地分类并编号，编号范围从 1 至 。初始时，每种商品的库存量均为 0。
为了高效地监控和调整库存量，小蓝的管理团队设计了m个操作，每个操作涉及到一个特定的商品区间，即一段连续的商品编号范围（例如区间[L,R]）。执行这些操作时，区间内每种商品的库存量都将增加1。然而，在某些情况下，管理团队可能会决定不执行某些操作，使得这些操作涉及的商品区间内的库存量不会发生改变，维持原有的状态。
现在，管理团队需要一个评估机制，来确定如果某个操作未被执行，那么最终会有多少种商品的库存量为0。对此，请你为管理团队计算出，每个操作未执行时，库存量为0的商品的种类数。
输入格式
第一行包含两个整数n和 m，分别表示商品的种类数和操作的个数。
接下来的m行，每行包含两个整数L和R，表示一个操作涉及的商品区间。
输出格式
输出共m行，每行一个整数，第i行的整数表示如果不执行第个操作，则最终库存量为0的商品种类数。
 */