package com.njx.Basic3;

import java.util.*;

public class Test3 {
    static LinkedList<Character> table = new LinkedList<>();

    public static LinkedList<Character> putCard(LinkedList<Character> a, LinkedList<Character> b) {

        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;

        char card = a.removeFirst(); // 相当于 pop(0)
        table.add(card);

        // 统计出现次数
        int count = Collections.frequency(table, card);

        if (count > 1) { // 赢牌
            int idx = table.indexOf(card);

            // 取出 table[idx:]
            List<Character> temp = new ArrayList<>();
            for (int i = idx; i < table.size(); i++) {
                temp.add(table.get(i));
            }

            // 保留 table[:idx]
            LinkedList<Character> newTable = new LinkedList<>();
            for (int i = 0; i < idx; i++) {
                newTable.add(table.get(i));
            }
            table = newTable;

            // 逆序加入 a
            Collections.reverse(temp);
            a.addAll(temp);

            return putCard(a, b);
        } else {
            return putCard(b, a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strA = sc.nextLine();
        String strB = sc.nextLine();

        LinkedList<Character> A = new LinkedList<>();
        LinkedList<Character> B = new LinkedList<>();

        for (char c : strA.toCharArray()) A.add(c);
        for (char c : strB.toCharArray()) B.add(c);

        LinkedList<Character> res = putCard(A, B);

        StringBuilder sb = new StringBuilder();
        for (char c : res) sb.append(c);

        System.out.println(sb.toString());
    }
}
/*
小的时候，你玩过纸牌游戏吗？
有一种叫做"拉马车"的游戏，规则很简单，却很吸引|小朋友。
其规则简述如下:
假设参加游戏的小朋友是 A 和 B，游戏开始的时候，他们得到的随机的纸牌序列如下:
A方: [K,8,X,K,A,2, A,9,5, A]
B方: [2,7,K,5,J,5,Q,6,K,4]
其中的X 表示"10"，我们忽略了纸牌的花色。从 A 方开始，A、B双方轮流出牌。
当轮到某一方出牌时，他从自己的纸牌队列的头部拿走一张，放到桌上，并且压在最上面一张纸牌上（如果有的话）。
此例中，游戏过程：
A出K，B出2，A出8，B出7，A出X，此时桌上的序列为:
K,2,8,7, X
当轮到 B 出牌时，他的牌 K 与桌上的纸牌序列中的 K 相同，则把包括 K 在内的以及两个 K 之间的纸牌都赢回来，
放入自己牌的队尾。注意：为了操作方便，放入牌的顺序是与桌上的顺序相反的。
此时，A、B双方的手里牌为:A方: [K,A,2,A,9,5,A]
B方: [5,J,5,Q,6,K,4, K,X,7,8,2,K]
赢牌的一方继续出牌。也就是 B 接着出 5，A 出 K，B 出J，A 出 A，B 出 5，又赢牌了。此时桌上的序列为:5,K,J,A,5
此时双方手里牌:A方:[2, A,9,5, A]
B方: [Q,6,K,4, K, X,7,8,2, K,5, A, J, K,5]注意：更多的时候赢牌的一方并不能把桌上的牌都赢走，而是拿走相同牌点及其中间的部分。
但无论如何，都是赢牌的一方继续出牌，有的时候刚一出牌又赢了，也是允许的。当某一方出掉手里最后一张牌，但无法从桌面上赢取牌时，游戏立即结束。
对于本例的初始手牌情况下，最后 A 会输掉，而 B 最后的手里牌为：
9K2A62KAX58K57KJ5
本题的任务就是已知双方初始牌序，计算游戏结束时，赢的-方手里的牌序。当游戏无法结束时，输出-1。
输入描述
输入为 2 行，2 个串，分别表示 A、B 双方初始手里的牌序列。我们约定，输入的串的长度不超过 30。
2J9A7QA6Q6889977
输出描述
输出为1行，1个串，表示 A先出牌，最后赢的一方手里的牌序。
 */