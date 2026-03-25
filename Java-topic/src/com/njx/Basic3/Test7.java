package com.njx.Basic3;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //输入数据...
        int n = scan.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            arr[i] = scan.nextInt();
        }

        //操作数据
        int count = 0;
        for(int i = 1; i <= n; i ++){
            //遍历每个数据，放到合适的地方
            if(arr[i] != i){
                // temp arr[i] arr[arr[i]]  arr[i]应该放在arr[arr[i]]
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
                count ++;
                i = 1;
            }
        }
        System.out.println(count);
    }
}
/*
有 N 个瓶子，编号 1～ N，放在架子上。比如有 5 个瓶子:
21354
要求每次拿起 2个瓶子，交换它们的位置。
经过若干次后，使得瓶子的序号为：
12345
对于这么简单的情况，显然，至少需要交换2次就可以复位。
如果瓶子更多呢？你可以通过编程来解决。
输入描述
输入格式为两行：
第一行:一个正整数 N (N < 104),表示瓶子的数目
第二行：N 个正整数，用空格分开，表示瓶子目前的排列情况。
输出描述
输出数据为一行一个正整数，表示至少交换多少次，才能完成排序。
 */