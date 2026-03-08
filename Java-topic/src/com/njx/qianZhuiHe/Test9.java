package com.njx.qianZhuiHe;

import java.util.*;

public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        String s = sc.next();
        char c1 = sc.next().charAt(0);
        char c2 = sc.next().charAt(0);
        int n = s.length();

        int[] pre =new int[n+1] ;
        for (int i = 0; i < n; i++) {
            pre[i+1]=pre[i];
            if(s.charAt(i)==c1)
                pre[i+1]++;
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if(s.charAt(j)==c2)
            {
                int limit=j-K+1;
                if(limit>=0)
                {
                    ans+=pre[limit+1];
                }
            }
        }
        System.out.println(ans);
    }
}
/*程序猿圈子里正在流行一种很新的简写方法：对于一个字符串，只保留首尾字符，将首尾字符之间的所有字符用这部分的长度代替。例如 internation-alization 简写成i18n，Kubernetes （注意连字符不是字符串的一部分）简写成K8s,Lanqiao 简写成L5o等。
在本题中，我们规定长度大于等于K 的字符串都可以采用这种简写方法（长度小于 K 的字符串不配使用这种简写）。
给定一个字符串S和两个字符c1和 c2，请你计算S有多少个以 c1 开头 C2 结尾的子串可以采用这种简写？
输入格式
第一行包含一个整数K。
第二行包含一个字符串 S 和两个字符 c1 和 c2。
输出格式
一个整数代表答案。

 */