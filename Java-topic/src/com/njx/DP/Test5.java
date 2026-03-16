package com.njx.DP;

public class Test5 {
    public static void main(String[] args) {
        int n = 2022;  //从下标为1开始，方便计算
        int[] q = new int[n]; //存储最短路
        q[1] = 0; //起始条件
        for (int i = 2; i <= 2021; i++) {
            q[i] = Integer.MAX_VALUE; //数组初始化放入一个大数
        }
        //dp
        //当前q[j] 表示 从 1~j的最短距离
        //q[j] 可以是 当前 1~j的最短距离 或者 前一状态 到 该点的最短距离
        for (int i = 1; i <= 2020; i++) {
            for (int j = i + 1; j <= 2021 && (j - i <= 21); j++) {
                q[j] = Math.min(q[j], q[i] + le(i, j)); //dp递推公式
            }
        }
        System.out.println(q[2021]);
    }

    //求最大公约数
    static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    //求最小公倍数
    static int le(int a, int b) {
        return a * b / gcd(a, b);

    }
}
/*
小蓝学习了最短路径之后特别高兴，他定义了一个特别的图，希望找到图中的最短路径。
小蓝的图由 2021 个结点组成，依次编号1 至 2021。
对于两个不同的结点 a, b， 如果 a 和 b 的差的绝对值大于 21， 则两个结点 之间没有边相连；如果 a 和 b 的差的绝对值小于等于21，则两个点之间有一条 长度为 a 和 b 的最小公倍数的无向边相连。
例如：结点 1 和结点 23 之间没有边相连；结点 3 和结点 24 之间有一条无 向边，长度为 24；结点 15 和结点 25 之间有一条无向边，长度为 75。
请计算，结点1和结点2021之间的最短路径长度是多少。
 */