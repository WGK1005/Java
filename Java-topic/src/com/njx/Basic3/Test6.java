package com.njx.Basic3;
import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        int cout=0;
        int win=0;
        int lose=0;
        Scanner scanner = new Scanner(System.in);

        for (int r=1; r<=3; r++) {
            System.out.println("第" + r + "局");
            System.out.println("\n用户出了 (剪刀（0）石头（1）布（2）):");
            int user=scanner.nextInt();
            int computer = (int)(Math.random()*3);
            System.out.println("电脑出了：");
            printGesture(computer);
            if(user == computer) {
                System.out.println("平局！");
                cout++;
            } else if ((user == 0 && computer == 2) ||
                    (user == 1 && computer == 0) ||
                    (user == 2 && computer == 1)) {
                System.out.println("你赢了！");
                win++;
            } else {
                System.out.println("电脑赢了！");
                lose++;
            }
        }

        System.out.println("===== 游戏结束 =====");
        System.out.println("最终比分 - 平局：" + cout + ", 你赢：" + win + ", 电脑赢：" + lose);

        if (win > lose) {
            System.out.println("恭喜你获得了最终胜利！");
        } else if (win < lose) {
            System.out.println("电脑获得了最终胜利，继续加油！");
        } else {
            System.out.println("双方战平！");
        }

        scanner.close();
    }

    private static void printGesture(int choice) {
        switch (choice) {
            case 0:
                System.out.println("剪刀");
                break;
            case 1:
                System.out.println("石头");
                break;
            case 2:
                System.out.println("布");
                break;
        }
    }
}


