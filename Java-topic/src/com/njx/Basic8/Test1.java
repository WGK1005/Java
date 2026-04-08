package com.njx.Basic8;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int T = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int left =1;
        list.add(left);
        int right = left+K;
        for (; right <= 1000000; right++) {
            if (gcd(left,right)==1) {
                left=right+1;
                list.add(left);
                right=left+K-1;
            }
        }
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            boolean flag = false;
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1) > n) {
                    flag = true;
                    System.out.println(i1);
                    break;
                }
            }
            if (!flag) {
                System.out.println(list.size());
            }
        }
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
/*
美丽区间是这样的一组区间：L1，R1]、[L2，R2]
[L3，R3…构造美丽区间需要满足以下条件：
1. L1 = 1
2. Li ≤ Ri
3. Ri − Li ≥ K
4.对于任意的 i >1，有 Li = Ri−1 + 1
5. gcd(Li， Ri）= 1，其中 gcd 指两个数的最大公约数
6. 在满足上述条件的情况下，Li、Ri之间的差尽可能的
小。
输入格式
第一行输入一个整数 K。第二行输入一个整数T，表示有T 组测试用例。接下来T行，每行输入一个整数n。
输出格式
对每个输入的整数n，输出一行，包含一个整数，表示n 属于第几个美丽区间。
 */