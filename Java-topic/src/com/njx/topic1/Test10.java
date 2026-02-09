package com.njx.topic1;
import java.util.*;
public class Test10 {
    public static void main(String[] args) {
        //在数列 α1,α2,···,αn 中，如果对于下标i, j,k 满足 0 <i < j <k<n+ 1且a <aj < ak，则称a,aj,ak为-组递增三元组，α; 为递增三元组的中心。
        //给定一个数列，请问数列中有多少个元素可能是递增三元组的中心。
        //输入描述
        //输入的第一行包含一个整数n。
        //第二行包含n个整数α1,α2,···，αn，相邻的整数间用空格分隔，表示给定的数列。
        //其中，2≤n≤ 1000，0≤ 数列中的数≤10000。
        //输出描述
        //输出一行包含一个整数，表示答案。
        //只要左右都有符合左小右大即可，不要求紧挨着

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = 0;

        // 枚举中心位置 j
        for (int j = 1; j <= n - 2; j++) {
            boolean hasSmallerLeft = false;
            boolean hasLargerRight = false;

            // 左边找 a[i] < a[j]
            for (int i = 0; i < j; i++) {
                if (a[i] < a[j]) {
                    hasSmallerLeft = true;
                    break;
                }
            }

            // 右边找 a[k] > a[j]
            for (int k = j + 1; k < n; k++) {
                if (a[k] > a[j]) {
                    hasLargerRight = true;
                    break;
                }
            }

            if (hasSmallerLeft && hasLargerRight) {
                ans++;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
