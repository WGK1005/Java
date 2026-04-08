package com.njx.Basic7;

import java.util.*;

public class Test15 {
    public static void main(String[] args) {
        String[] names = {"张三", "李四", "王五"};
        int[][] scores = {{80, 90, 100}, {90, 100, 80}, {100, 80, 90}};
        int[] totalScores = new int[3];
        double[] avgScores = new double[3];
            
        // 计算总分和平均分
        for (int i = 0; i < names.length; i++) {
            int sum = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
            }
            totalScores[i] = sum;
            avgScores[i] = sum / 3.0;
        }
            
        // 使用StringBuilder生成成绩报表（演示StringBuilder的可变性）
        System.out.println("\n学生成绩汇总报表（使用StringBuilder）：");
        StringBuilder report = new StringBuilder();
            
        // 添加表头
        report.append("\n========== 学生成绩报表 ==========\n");
        report.append(String.format("%-8s %-8s %-8s %-8s %-8s %-8s%n", "姓名", "数学", "语文", "英语", "总分", "平均分"));
        report.append("-".repeat(50)).append("\n");
            
        // 添加每行数据
        for (int i = 0; i < names.length; i++) {
            report.append(String.format("%-8s %-8d %-8d %-8d %-8d %-8.2f%n",
                    names[i], scores[i][0], scores[i][1], scores[i][2], totalScores[i], avgScores[i]));
        }
            
        report.append("=".repeat(50)).append("\n");
        report.append("报表生成时间：").append(new java.util.Date()).append("\n");
            
        System.out.println(report.toString());
    }
}
/*
1、问题描述：
设计一个《学生成绩管理系统》，管理一个班级的学生信息和考试成绩。需要计算学生的
门课成绩的总成绩和平均成绩，并生成成绩报表。
2、设计思路：
（1）使用一维数组存储3名学生姓名（String对象的不变性演示）；
（2）使用二维数组存储成绩每名学生3门课程的成绩；
（3）计算每个学生的总分和平均分；
（4）使用StringBuilder生成成绩报表（演示StringBuilder的可变性）。
 */