package com.njx.TanXin;

import java.util.*;
//通过率70，这个是思虑清晰的解法，但是不对，主要是因为没有考虑到当M>same时，sum可能会超过N，所以需要减去多余的部分
//codex的解法是直接计算出小蓝答对的题目数量，然后根据M和same的关系来调整这个数量，最终得到正确的结果
public class Test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        String S=sc.next();
        String T=sc.next();

        int same=0;
        int diff=0;
        for(int i=0;i<N;i++){
            if(S.charAt(i)==T.charAt(i)){
                same++;
            }else{
                diff++;
            }
        }
        // max = min(same, M) + min(diff, N - M)
        int ans = Math.min(same, M) + Math.min(diff, N - M);
        System.out.println(ans);
        // int ans = diff + Math.min(same, m);
        //
        //        if(m > same){
        //            ans -= (m - same);
        //        }
        //这是之前70的解法。
    }
}
/*
小蓝从一间空荡的房间中醒来，眼前放着一张木桌，桌上摆放着两份密封的答案纸，一份属于他，另一份属于他的朋友。每张纸上都写着一个长度为 N 的字符串，仅包含字符‘T’和‘F’一一这是他们昨晚参加一场判断题考试后的答题记录。
考试共有N道题目，每题的答案只有两种可能：
·“T'表示“True”(正确)·‘F'表示“False”(错误)
两人在相互隔离、无法交流的情况下各自完成了作答，并提交了自己的答案。今早，小蓝收到了一条神秘信息：
·你的朋友恰好答对了M 道题。
标准答案尚未公布，小蓝无法直接判断自己答对了多少题。然而，基于已知信息，小蓝希望评估出，在所有可能的标准答案中，他自己最多能答对多少题。现在，请你计算小蓝至多能答对的题目数量。
输入格式
第一行包含两个整数N和M，分别表示题目数量和朋友答对的题目数量。
第二行包含一个长度为 N、仅由字符‘T’和‘F’组成的字符串 S，表示小蓝的答案。
第三行包含一个长度为 N、仅由字符‘T'和‘F’组成的字符串 T，表示朋友的答案。
输出格式
输出一个整数，表示在所有可能的标准答案中，小蓝最多能答对的题目数量。
 */