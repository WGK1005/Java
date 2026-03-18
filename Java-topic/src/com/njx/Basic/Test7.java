package com.njx.Basic;

import java.util.*;
//题解中的，还是高手多啊，ai的无法通过
public class Test7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int T=scan.nextInt();
        while(T-->0){
            int n=scan.nextInt();
            int[] cnt=new int[20];
            for(int i=0;i<n;i++){
                int x=scan.nextInt();
                int p=0;
                while(x!=0){
                    cnt[p++]+=(x&1);
                    x>>=1;
                }
            }
            int res=0;
            for(int i=19;i>=0;i--){
                if((cnt[i]&1)==1){
                    res=(cnt[i]==1||(n&1)==1)?1:-1;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
/*
Alice 和 Bob 正在玩一个异或数列的游戏。 初始时，Alice 和 Bob分别有一个整数α 和 6，初始值均为 0。
有一个给定的长度为 n 的公共数列 X1, X2,···,Xn。Alice 和Bob 轮流操作，Alice 先手，每步可以在以下两种选项中选一种：
选项 1：从数列中选一个 X 给 Alice 的数异或上，或者说令 α变为 α  X。 (其中  表示按位异或)
选项 2：从数列中选一个 X; 给 Bob 的数异或上，或者说令 6 变为b Xio
每个数 X都只能用一次，当所有 X;均被使用后（n 轮后）游戏结束。游戏结束时，拥有的数比较大的一方获胜，如果双方数值相同，即为平手。现在双方都足够聪明，都采用最优策略，请问谁能获胜?
输入描述
每个评测用例包含多组询问。询问之间彼此独立。
输入的第一行包含一个整数T，表示询问数。
接下来 T 行每行包含一组询问。其中第i 行的第一个整数 n 表示数列长度，随后 n个整数 X1,X2，···，Xn 表示数列中的每个数。
输出描述
输出 T 行，依次对应每组询问的答案。每行包含一个整数1、0或-1 分别表示 Alice 胜、平局或败。
 */