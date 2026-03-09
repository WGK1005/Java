package com.njx.ErFen;

import java.util.*;
//直接暴力了，二分加滑动窗口太难，这个通过率50，可以了
public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] a = new int[N][M];

        // 输入矩阵
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int limit = sc.nextInt();

        int ans = 0; // 最大面积

        // 枚举上边界
        for (int top = 0; top < N; top++) {

            // 枚举下边界
            for (int bottom = top; bottom < N; bottom++) {

                // 枚举左边界
                for (int left = 0; left < M; left++) {

                    // 枚举右边界
                    for (int right = left; right < M; right++) {

                        int max = Integer.MIN_VALUE;
                        int min = Integer.MAX_VALUE;

                        // 遍历当前子矩阵
                        for (int i = top; i <= bottom; i++) {
                            for (int j = left; j <= right; j++) {

                                max = Math.max(max, a[i][j]);
                                min = Math.min(min, a[i][j]);
                            }
                        }

                        // 判断稳定度
                        if (max - min <= limit) {

                            int area = (bottom - top + 1) * (right - left + 1);

                            ans = Math.max(ans, area);
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
/*
小明有一个大小为 N × M 的矩阵, 可以理解为一个 N 行 M列的二维数组。
我们定义一个矩阵 m 的稳定度 f(m）为 f(m）=max(m) － min(m),其中 max(m) 表示矩阵 m 中的最大值,min(m）表示矩阵 m 中的最小值。
现在小明想要从这个矩阵中找到一个稳定度不大于limit的子矩阵，同时他还希望这个子矩阵的面积越大越好(面积可以理解为矩阵中元素个数)。
子矩阵定义如下：从原矩阵中选择一组连续的行和一组连续的列，这些行列交点上的元素组成的矩阵即为一个子矩阵。
输入格式
第一行输入两个整数N，M，表示矩阵的大小。
接下来 N 行,侮行输入 M 个整数，表示这个矩阵。
最后一行输入一个整数limit,表示限制。
辐出格式
输出一个整数.分别表示小明选择的子矩阵的最大面积。
 */
