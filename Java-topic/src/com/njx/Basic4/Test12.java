package com.njx.Basic4;

import java.util.*;
import java.io.*;

public class Test12 {
    static int T;
    static int N;
    static int t[], d[], l[];//到达机场的时刻 ,飞机还能飞多久 , 飞机离开跑道的时刻 (下一驾飞机开始降落的时刻)
    static boolean st[];//判断飞机是否已经降落
    static boolean flag = false; // 默认不能降落

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); // 输入测试数据的组数
        while (T-- > 0) {
            N = sc.nextInt(); // 输入有几架飞机
            t = new int[N + 1]; //存放每架飞机到达机场的时间
            d = new int[N + 1]; //存放飞机还能在机场盘旋的时间
            l = new int[N + 1]; // 飞机离开跑道的时间
            st = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                t[i] = sc.nextInt();
                d[i] = sc.nextInt();
                l[i] = sc.nextInt();
            }


            dfs(0, 0);//进行dfs搜索
            System.out.println(flag ? "YES" :"NO");
            flag = false;//进入下一组测试数据 ,将其重置为不能降落
        }
    }
    /*
     * number 降落飞机的数量
     * time 当前时刻
     * */
    private static void dfs(int number, int time) {// 飞机降落个数 , 飞机降临时间
        if (number >= N) {//如果当前降落飞机的数量大于总数量
            flag = true;//标记为可以成功降落
            return; // 并进行回溯
        }
        for (int i = 1; i <= N; i++) {//从有几驾飞机开始
            if (!st[i]) {//如果当前飞机没有降落
                if (t[i] + d[i] >= time) {//如果最大停留时间大于现在的时间 ,就说明这个飞机可以降落
                    st[i] = true;
                    if (time < t[i]) {// 如果当前时间小于飞机到达机场的时间  ,也就是说前面一架飞机都完事了 ,下一驾飞机还没到 ,
                        dfs(number + 1, t[i] + l[i]);//飞机数量增加,并且由于前一驾飞机走了还没到 ,所以到了直接降落就行 当前时间 = 飞机到达机场时间 + 离开跑道的时间
                    }else {//如果当前时间大于飞机到机场的时间
                        dfs(number + 1,time + l[i]);//代表人家已经到半天了 ,直接降落走跑道就行
                    }
                    st[i] = false;//回溯之后重新标记这一架飞机没有降落
                }

            }
        }

    }
}
/*
N架飞机准备降落到某个只有一条跑道的机场。其中第i架飞机在T时刻到达机场上空，到达时它的剩余油料还可以继续盘旋Di个单位时间，即它最早可以于T时刻开始降落，最晚可以于Ti+Di时刻开始降落。降落过程需要Li个单位时间。
-架飞机降落完毕时，另一架飞机可以立即在同一时刻开始降落，但是不能在前一架飞机完成降落前开始降落。
请你判断N架飞机是否可以全部安全降落。
输入格式
输入包含多组数据。
第一行包含一个整数T，代表测试数据的组数。对于每组数据，第一行包含一个整数N。以下N行，每行包含三个整数：Ti，Di和Li。
输出格式
对于每组数据，输出YES 或者NO，代表是否可以全部安全降落。
 */