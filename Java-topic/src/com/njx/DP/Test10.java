package com.njx.DP;

import java.util.*;

public class Test10 {
    static class Edge{
        int u,v,w;
        Edge(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }

    static int[] parent;
    static long[] size;

    static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        int L=sc.nextInt();
        int R=sc.nextInt();

        Edge[] edges=new Edge[M];

        for(int i=0;i<M;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            edges[i]=new Edge(u,v,w);
        }

        Arrays.sort(edges,(a,b)->a.w-b.w);

        parent=new int[N+1];
        size=new long[N+1];

        for(int i=1;i<=N;i++){
            parent[i]=i;
            size[i]=1;
        }

        long ans=0;

        for(Edge e:edges){

            int fu=find(e.u);
            int fv=find(e.v);

            if(fu!=fv){

                long pairs=size[fu]*size[fv];

                if(e.w>=L && e.w<=R){
                    ans+=pairs;
                }

                parent[fu]=fv;
                size[fv]+=size[fu];
            }
        }

        System.out.println(ans);
    }

}

/*
的，并且任意两座城币之间最多只有一条直接的商路。每条商路都有它的规则，其中最引人注目的就是穿过商路，需要缴纳过路费。因此，商人们在选择商路时必须格外认真。
有一位名叫小蓝的商人，他对于商路的花费有着自己独到的见解。在小蓝眼中，一条路线包含一条或多条商路，但路线的成本并不是沿途累积的过路费总和，而是这条路线上最贵的那一次收费。这个标准简单而直接，让他能迅速评估出一条路线是否划算。
于是，他设立了一个目标，即找出所有城市对，这些城市之间的最低路线成本介于他心中预设的两个数L和 R 之间。他相信，这样的路线既不会太廉价，以至于路况糟糕；也不会过于昂贵，伤害他精打细算的荷包。
作为小蓝的助手，请你帮助小蓝统计出所有满足条件的城市对数量。
输入格式
第一行包含四个整数 N，M,L,R，表示有 N 座城市和 M 条双向通行的商路，以及小蓝心中预设的最高过路费的下限L和上限R。
接下来 M 行，每行包含三个整数u,,w，表示城市和城市u之间有一条双向通行的商路，过路费为w。保证每对城市之间最多只有一条直接的商路。
输出格式
输出仅一行，包含一个整数，表示满足条件的城市对数量。
 */
