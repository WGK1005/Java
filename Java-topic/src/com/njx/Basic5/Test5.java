package com.njx.Basic5;

import java.util.*;
//看到题解有一个很厉害的思路
//一组K只宠物,那么没有宠物感染的概率就是P=(1-p)^K,至少有一只宠物感染的概率即1-P,
// 对于对于一共N/K组,自然即有PN/K组未感染,(1-P)N/K组感染,未感染的话只需1只药剂,否则需要(1+K)支药剂(K==1时除外)
// (官解的公式里写成1K了,但是代码是对的,结果我看半天不知道为什么),
// 那么用药数量就是E=(P+(1-P)(K+1))*N/K了,对于N是否能正好分成K份,因为数据小直接暴力就完事
public class Test5 {
    static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        int N=input.nextInt(), minK=Integer.MAX_VALUE;
        double p=input.nextDouble(),miny=Double.MAX_VALUE;
        for(int K=N; K>=1; K--){
            if(N%K==0){
                double P=Math.pow(1-p,K);
                double E=(P+(1-P)*(K+1))*N/K;
                if(K==1) E=N;
                if(E<=miny){
                    miny=E;
                    minK=K;
                }
            }
        }
        System.out.println(minK);
    }
}
/*
小蓝开了一家宠物店，最近有一种Χ病毒在动物之间进行传染，小蓝为了以防万一打算购买测试剂对自己的宠物进行病毒感染测试。
为了减少使用的测试剂数目，小蓝想到了一个好方法：将N个宠物平均分为若干组，使得每组恰好有K只宠物，
这样对同一组的宠物进行采样并混合后用一个试剂进行检测，如果测试结果为阴性则说明组内宠物都未感染X病毒；
如果是阳性的话则需要对组内所有K只宠物单独检测，需要再消耗 K 支测试剂（当 K =1时，就没必要再次进行单独检测了，
因为组内只有一只宠物，一次检测便能确认答案）。现在我们已知小蓝的宠物被感染的概率为p，
请问 K 应该取值为多少才能使得期望的测试剂的消耗数目最少？如果有多个答案输出最小的K。
输入格式
第一行，—个整数 N。
第二行，一个浮点数p。
输出格式
输出一行，一个整数 K 表示答案。
 */