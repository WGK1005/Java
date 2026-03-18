package com.njx.Basic;

import java.util.*;
//暴力也是能全通过的
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int m = scanner.nextInt();

        int[][][] d = new int[A + 1][B + 1][C + 1];
        int[][][] damage = new int[A + 1][B + 1][C + 1];

        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 1; k <= C; k++) {
                    d[i][j][k] = scanner.nextInt();
                }
            }
        }

        for (int round = 1; round <= m; round++) {
            int lat = scanner.nextInt();
            int rat = scanner.nextInt();
            int lbt = scanner.nextInt();
            int rbt = scanner.nextInt();
            int lct = scanner.nextInt();
            int rct = scanner.nextInt();
            int ht = scanner.nextInt();

            for (int i = lat; i <= rat; i++) {
                for (int j = lbt; j <= rbt; j++) {
                    for (int k = lct; k <= rct; k++) {
                        damage[i][j][k] += ht;
                        if (damage[i][j][k] > d[i][j][k]) {
                            System.out.println(round);
                            return;
                        }
                    }
                }
            }
        }
    }
}
/*
三体人将对地球发起攻击。为了抵御攻击，地球人派出 A ×B × C 艘战舰，在太空中排成一个 A 层 B 行 C 列的立方体。其中，第 层第 j 行第 k 列的战舰(记为战舰 (i, j，k))的生命值为 d(i, j, k)。
三体人将会对地球发起m轮"立方体攻击"，每次攻击会对一个小立方体中的所有战舰都造成相同的伤害。具体地，第t轮攻击用7 个参数lat, rat, tbt, rbt,lct, rct,ht 描述;
所有满足i ∈ [lat, rat],j ∈ [bt, rbt],k ∈ [lct, rct] 的战舰（，J，k）会受到 ht 的伤害。如果一个战舰累计受到的总伤害超过其防御力，那么这个战舰会爆炸。
地球指挥官希望你能告诉他，第一艘爆炸的战舰是在哪一轮攻击后爆炸的。
输入描述
输入格式:
第一行包括 4 个正整数 A，B，C，m;
第二行包含 A × B × C 个整数，其中第((i－1)× B +(j - 1)) × C + (k - 1) + 1 个数为 d(i, j, k);第 3到第 m+ 2 行中，第(t－ 2)行包含 7 个正整数lat, rat, lbt, rbt, lct, rct, ht.
其中,A × B × C ≤ 10°,m ≤ 10°,0 ≤d(i, j, k), ht ≤ 10%.
输出描述
输出第一个爆炸的战舰是在哪一轮攻击后爆炸的。保证一定存在
 */