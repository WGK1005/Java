package com.njx.qianZhuiHe;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] diff=new int[n+2][n+2];
        for(int i=0;i<m;i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            diff[x1][y1]+=1;
            diff[x2+1][y2+1]+=1;
            diff[x1][y2+1]-=1;
            diff[x2+1][y1]-=1;

        }

        int[][] a=new int[n+1][n+1];
        // 前缀和恢复棋盘
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                a[i][j] = diff[i][j]
                        + a[i-1][j]
                        + a[i][j-1]
                        - a[i-1][j-1];

                a[i][j] &= 1; // 奇偶决定颜色
            }
        }
        StringBuilder out = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                out.append(a[i][j]);
            }
            out.append('\n');
        }
        System.out.print(out);

    }
}
/**
 * 小蓝拥有  ×  大小的棋盘，一开始棋盘上全都是白子。小蓝进行了㎡次操作，每次操作会将棋盘上某个范围内的所有棋子的颜色取反（也就是白色棋子变为黑色，黑色棋子变为白色）。请输出所有操作做完后棋盘上每个棋子的颜色。
 * 输入格式
 * 输入的第一行包含两个整数，m，用一个空格分隔，表示棋盘大小与操作数。
 * 接下来m 行每行包含四个整数α1，y1，∞2，y2，相邻整数之间使用一个空格分隔， 表示将在 ∞1 至 ∞2 行和 y1 至 y2 列中的棋子颜色取反。
 * 输出格式
 * 输出 n 行，每行 n 个 0 或 1 表示该位置棋子的颜色。如果是白色则输出 0，否则输出 1。
 */
