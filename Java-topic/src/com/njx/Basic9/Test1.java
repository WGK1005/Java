package com.njx.Basic9;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "FFEEFEAAECFFBDBFBCDA" +
                "DACDEEDCCFFAFADEFBBA" +
                "FDCDDCDBFEFCEDDBFDBE" +
                "EFCAAEECEECDCDECADDC" +
                "DFAEACECFEADCBFECADF" +
                "DFBAAADCFAFFCEADFDDA" +
                "EAFAFFDEFECEDEEEDFBD" +
                "BFDDFFBCFACECEDCAFAF" +
                "EFAFCDBDCCBCCEADADAE" +
                "BAFBACACBFCBABFDAFBE" +
                "FCFDCFBCEDCEAFBCDBDD" +
                "BDEFCAAAACCFFCBBAAEE" +
                "CFEFCFDEEDCACDACECFF" +
                "BAAAFACDBFFAEFFCCCDB" +
                "FADDDBEBCBEEDDECFAFF" +
                "CDEAFBCBBCBAEDFDBEBB" +
                "BBABBFDECBCEFAABCBCF" +
                "FBDBACCFFABEAEBEACBB" +
                "DCBCCFADDCACFDEDECCC" +
                "BFAFCBFECAACAFBCFBAF";

        int[] count = new int[6];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A'] += 1;
        }
        Arrays.sort(count);
        System.out.println(count[5]);
    }
}
/*
边境森林中分布着若干重要的哨站，所有哨站之间由隐秘小径相连，形成一张天然的巡逻网络。这张网络的结构恰好是一棵树。
为了防止敌人渗透，小蓝每天需要执行固定长度为k的巡逻任务。
每次巡逻从一个哨站出发，经过不重复地恰好k条道路，最终到达另一个哨站。每条道路都有一定的危险值，巡逻路径上危险值的和代表该次巡逻时的风险。
两次巡逻路径不相同当且仅当它们的起点不同或终点不同。
现在指挥官希望知道，所有可能的长度为κ的巡逻路线的风，险之和是多少?
输入格式
输入的第一行包含两个正整数n，k，用一个空格分隔。
接下来n一1 行，每行包含三个正整数 ui，Ui，Wi，相邻整数之间使用一个空格分隔。表示结点ui和结点υi之间有一条危险值为wi边。
输出格式
输出一行包含一个整数表示答案。
 */