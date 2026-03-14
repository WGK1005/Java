package com.njx.TanXin;

import java.util.*;
//蓝桥杯的测试案例与答案不对，可忽略。
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        long sum = 0L;

        int free = 0;
        int ex = n - 1;
        while (ex >= free) {
            sum += a[ex];
            ex--;
            if (ex < free) {
                break;
            }

            // 买第二件，较便宜价格为 p
            sum += a[ex];
            int p = a[ex];
            ex--;

            // 免费拿一件：价格 <= p / 2
            if (free <= ex && a[free] <= p / 2) {
                free++;
            }
        }
        System.out.println(sum);

    }
}
/*
某商场有 N 件商品，其中第件的价格是 A。现在该商场正在进行“买二赠一”的优惠活动，具体规则是：每购买2件商品，假设其中较便宜的价格是P（如果两件商品价格一样，则P等于其中一件商品的价格），就可以从剩余商品中任选一件价格不超过的商品，免费获得这一件商品。可以通过反复购买 2 件商品来获得多件免费商品，但是每件商品只能被购买或免费获得一次。
小明想知道如果要拿下所有商品（包含购买和免费获得），至少要花费多少钱？
输入格式
第一行包含一个整数N。
第二行包含N 个整数，代表A1,A2,A3，···，AN。
输出格式
输出一个整数，代表答案。
 */