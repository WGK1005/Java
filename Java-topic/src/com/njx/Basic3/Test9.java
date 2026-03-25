package com.njx.Basic3;

import java.util.*;

public class Test9 {
    static int n,m,k;
    static Queue<int[]> queue =new LinkedList<>();
    static char c[][];
    static int dx[]=new int[]{0,-1,0,1};
    static int dy[]=new int[]{1,0,-1,0};
    public static void main(String[] args) {
        Scanner sn=new Scanner(System.in);
        n=sn.nextInt();
        m=sn.nextInt();
        c=new char[n][m];
        for(int i=0;i<n;i++) {
            c[i]=sn.next().toCharArray();
            for(int j=0;j<m;j++) {
                if(c[i][j]=='g')
                    queue.offer(new int[] {i,j});//含有g的存储在队列
            }
        }
        k=sn.nextInt();
        BFS();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(c[i][j]);
            }
            System.out.println();
        }
    }
    public static void BFS(){
        while(k-->0) {
            int size=queue.size();//获取队列的长度
            for(int i=0;i<size;i++) {
                int a[]=queue.poll();
                for(int j=0;j<4;j++) {//四个方向搜索
                    int xx=a[0]+dx[j];
                    int yy=a[1]+dy[j];
                    if(xx>=0&&xx<n&&yy>=0&&yy<m&&c[xx][yy]=='.') {
                        c[xx][yy]='g';
                        queue.offer(new int[] {xx,yy});//将每个遍历过的方向存储在队列中
                    }
                }
            }
        }
    }
}
/*
小明有一块空地，他将这块空地划分为 n 行 m 列的小块，每行和每列的长度都为 1。
小明选了其中的一些小块空地，种上了草，其他小块仍然保持是空地。
这些草长得很快，每个月，草都会向外长出一些，如果一个小块种了草，则它将向自己的上、下、左、右四小块空地扩展,
这四小块空地都将变为有草的小块。请告诉小明，k 个月后空地上哪些地方有草。
输入描述
输入的第一行包含两个整数n,m。
接下来 n 行，每行包含 m 个字母，表示初始的空地状态,字母之间没有空格。如果为小数点，表示为空地，如果字母为 g，表示种了草。
接下来包含一个整数k。其中，2 ≤n,m ≤1000，1 ≤k ≤ 1000.
输出描述
输出 n 行，每行包含 m 个字母，表示 k 个月后空地的状态。如果为小数点，表示为空地，如果字母为 g，表示长了草。
 */