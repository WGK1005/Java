package com.njx.BaoLi;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int [][] b=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                b[i][j]=a[n-1-j][i];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
/*
图片旋转是对图片最简单的处理方式之一，在本题中，你需要对图片顺时针旋转 90 度。
我们用一个 × m 的二维数组来表示一个图片，例如下面给出一个 3 × 4 的 图片的例子:
1357
9876
3597
这个图片顺时针旋转90度后的图片如下:
391
583
975
7６7
给定初始图片，请计算旋转后的图片。
输入描述
输入的第一行包含两个整数n，m，分别表示行数和列数。
接下来 n 行，每行 m 个整数，表示给定的图片。图片中的每个元素（像素）为一个值为0 至 255 之间的整数（包含0 和
255)。
输出描述
输出 m 行 n 列，表示旋转后的图片。
 */