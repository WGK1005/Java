package com.njx.qianZhuiHe;

import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] A = new int[N + 1][M + 1];

        // 输入矩阵
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                A[i][j] = sc.nextInt();
            }
        }


        long ans = 0;

        // 枚举上边界
        for(int top = 1; top <= N; top++){

            long[] colSum = new long[M + 1];  // 每列累加和

            // 枚举下边界
            for(int bottom = top; bottom <= N; bottom++){

                // 更新每列的和
                for(int j = 1; j <= M; j++){
                    colSum[j] += A[bottom][j];
                }

                // 滑动窗口统计 ≤K
                long sum = 0;
                int left = 1;

                for(int right = 1; right <= M; right++){

                    sum += colSum[right];

                    // 如果超过K就移动左指针
                    while(sum > K && left <= right){
                        sum -= colSum[left];
                        left++;
                    }

                    // 统计以 right 结尾的合法区间
                    ans += (right - left + 1);
                }
            }
        }

        System.out.println(ans);

    }
}

/*
给定一个 N × M 的矩阵 A,请你统计有多少个子矩阵(最小1 × 1,最大 N × M）满足子矩阵中所有数的和不超过给定的整数K?
输入格式
第一行包含三个整数N，M和K.
之后N 行每行包含 M 个整数，代表矩阵A.
输出格式
一个整数代表答案。
 */

//会超时，能过70%,正常够用，但是更好的是用双指针+前缀和
/*public class Test2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[][] A = new int[N + 1][M + 1];
        long[][] sum = new long[N + 1][M + 1];

        // 输入矩阵
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                A[i][j] = sc.nextInt();
            }
        }

        // 构建二维前缀和
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sum[i][j] = sum[i-1][j]
                        + sum[i][j-1]
                        - sum[i-1][j-1]
                        + A[i][j];
            }
        }

        long ans = 0;

        // 枚举子矩阵
        for(int x1 = 1; x1 <= N; x1++){
            for(int y1 = 1; y1 <= M; y1++){

                for(int x2 = x1; x2 <= N; x2++){
                    for(int y2 = y1; y2 <= M; y2++){

                        long s = sum[x2][y2]
                                - sum[x1-1][y2]
                                - sum[x2][y1-1]
                                + sum[x1-1][y1-1];

                        if(s <= K){
                            ans++;
                        }

                    }
                }

            }
        }

        System.out.println(ans);

    }
}
 */
