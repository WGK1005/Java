package com.njx.topic3;
import java.util.*;

//暴力解法，不暴力很难通过蓝桥杯的测试

public class Test1 {
        static int n;
        static int[] ai,bi;//ai:北墙的箭靶   bi:西墙的箭靶
        static boolean[][] loop;//用来标记这个路是否走过
        static int[] xi= {-1,0,1,0};//偏移量，可以上下左右走
        static int[] yi= {0,1,0,-1};
        static List<Integer> lujing=new ArrayList<>();//用来记录你走的路径，存的是每一步的路径,(也可以用栈来存)
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            n=scanner.nextInt();
            ai=new int[n];
            bi=new int[n];
            loop=new boolean[n][n];
            for(int i=0;i<n;i++) ai[i]=scanner.nextInt();
            for(int i=0;i<n;i++) bi[i]=scanner.nextInt();
            //下面四行是初始化起点的操作
            loop[0][0]=true;//已走过起点
            ai[0]--;        //减去在起点的时候射过的箭
            bi[0]--;
            lujing.add(0); //第一步肯定是起点 先把起点加上去
            dfs(0, 0);
        }
        //dfs的参数只需要记录你当前走的是哪一个方格就好了 x:横坐标   y:纵坐标
        private static void dfs(int x,int y) {
            if(x==n-1&&y==n-1) {//如果走到了重点
                //这一步是判断走到终点的时候是否满足要求，是否射够了所有的箭靶
                for(int i=0;i<n;i++) {
                    if(ai[i]!=0||bi[i]!=0) return;//不满足直接返回
                }
                //如果满足条件就输出你的路径
                for(int lj:lujing) System.out.print(lj+" ");
                return;
            }
            //dfs核心代码，用来操作偏移量(也就是上下左右移动)
            for(int i=0;i<4;i++) {
                //获得加上偏移量后的坐标
                int xx=x+xi[i];
                int yy=y+yi[i];
                //check()函数用来判断当前坐标是否合格
                if(check(xx, yy)) {
                    bi[xx]--;//减去走这个方格的箭靶
                    ai[yy]--;
                    loop[xx][yy]=true;
                    lujing.add(xx*n+yy);//把这个路径加上去
                    dfs(xx, yy);
                    //下面四行就是回溯代码
                    lujing.remove(lujing.size()-1);
                    loop[xx][yy]=false;
                    bi[xx]++;
                    ai[yy]++;
                }
            }

        }

        //判断当前坐标是否满足要求
        private static boolean check(int x,int y) {
            //这一行是判断当前坐标是否越界 或者这个方格是否已经走过了
            if(x<0||y<0||x>=n||y>=n||loop[x][y]) return false;

            //这一行判断的是走这个方格的话 是否满足箭靶的要求，如果箭靶上的数<0了 说明这条路走多了一次，而且是不可逆的
            //直接返回false就好了
            //也相当于减枝了
            if(bi[x]-1<0 || ai[y]-1<0) return false;//(核心减枝代码)
            return true;
        }

    }
