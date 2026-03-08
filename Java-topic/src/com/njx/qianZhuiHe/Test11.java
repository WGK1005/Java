package com.njx.qianZhuiHe;

import java.util.*;
//贪心+前缀和
public class Test11 {
    // 定义士兵类，存储两个信息
    static class Soldier{
        long p;   // 单独训练一次的费用
        long c;   // 需要训练的次数
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 士兵数量
        long S = sc.nextLong(); // 一次组团训练的费用

        Soldier[] a = new Soldier[n]; // 存储所有士兵

        long base = 0; // base 表示：如果全部使用单独训练的总费用

        // 读取士兵数据
        for(int i = 0; i < n; i++){

            a[i] = new Soldier();

            a[i].p = sc.nextLong(); // 单次训练费用
            a[i].c = sc.nextLong(); // 需要训练次数

            // 全部单独训练的费用
            base += a[i].p * a[i].c;
        }

        /*
        按 c 排序
        为什么？

        因为当组团训练次数 k 增加时
        如果某个士兵 c[i] < k
        说明这个士兵已经训练满了
        不能再通过组团训练减少费用

        所以需要按 c 从小到大排序
        方便动态删除
        */
        Arrays.sort(a , Comparator.comparingLong(o -> o.c));

        /*
        sum_p 表示：

        当前还能被组团训练减少费用的
        所有士兵的 p 之和

        因为一次组团训练
        可以让每个士兵减少一次单独训练
        节省 p[i]
        */
        long sum_p = 0;

        for(int i = 0; i < n; i++){
            sum_p += a[i].p;
        }

        /*
        ans 保存最小花费
        先初始化为全部单独训练的费用
        */
        long ans = base;

        /*
        k 表示组团训练的次数
        */
        long k = 0;

        /*
        idx 用来扫描哪些士兵已经训练满
        */
        int idx = 0;

        /*
        当组团训练一次带来的节省 > S
        才值得继续组团训练

        因为：
        一次组团训练花费 S
        但能减少 sum_p 的单独训练费用
        */
        while(sum_p > S){

            /*
            当前总费用：

            原始单独训练费用 base
            + k 次组团训练费用
            */
            ans = Math.min(ans , base + k * S);

            // 组团训练次数 +1
            k++;

            /*
            检查哪些士兵已经训练满

            如果 c[i] < k
            说明这个士兵已经不需要训练了
            */
            while(idx < n && a[idx].c < k){

                /*
                这个士兵以后
                不会再贡献节省的费用
                */
                sum_p -= a[idx].p;

                idx++;
            }

            /*
            因为进行了一次组团训练

            base 要减少 sum_p
            (减少的单独训练费用)
            */
            base -= sum_p;
        }

        /*
        最后再计算一次答案
        */
        ans = Math.min(ans , base + k * S);

        System.out.println(ans);
    }
}
/*
在蓝桥王国中，有 n 名士兵，这些士兵需要接受一系列特殊的训练，以提升他们的战斗技能。对于第名士兵来说，进行一次训练所需的成本为 p 枚金币，而要想成为顶尖战士，他至少需要进行 c次训练。
为了确保训练的高效性，王国推出了一种组团训练的方案。该方案包含每位士兵所需的一次训练，且总共只需支付S枚金币（组团训练方案可以多次购买，即士兵可以进行多次组团训
练)。
作为训练指挥官，请你计算出最少需要花费多少金币，才能使得所有的士兵都成为顶尖战士？
输入格式
第一行包含两个整数 n和 S，表示士兵的数量和进行一次组团训练所需的金币数。
接下来的 n 行，每行包含两个整数 p: 和 c，表示第 i 名士兵进行一次训练的金币成本和要成为顶尖战士所需的训练次数。
输出格式
输出一个整数，表示使所有士兵成为顶尖战士所需的最少金币数。
 */