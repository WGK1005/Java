package com.njx.topic1;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        //统计个数
        //学校选举学生会主席，有5个候选人
        //全校1000名同学参与投票（每人一票，可以弃权，或者选1-5号）。投票使用Random模拟。0：弃权，1～5：给对应的候选人投票
        //要求1:
        //统计每个候选人的得票数和得票率，找出得票最多的候选人？
        //要求2:
        //统计弃票数和弃票率是多少？

        //1创建长度为6的数组，0索引代表弃权，1～5索引代表1～5号候选人
        int[] arr=new int[6];

        //2循环1000次
        Random r=new Random();
        for (int i = 0; i < 1000; i++) {
            //生成1-5投票数
            int vote=r.nextInt(0,6);
            arr[vote]++;
        }

        //3统计每个候选人得票数和得票率
        for (int i = 1; i < arr.length; i++) {
            System.out.println("第"+i+"个候选人的得票数是"+arr[i]+"，得票率是"+(arr[i]*1.0/1000)*100+"%");
        }

        //4找出最多票数
        int max=arr[1];
        for (int i =2; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        //5票数最多的候选人
        //可能票数相同
        for (int i= 1; i < arr.length; i++) {
            if(max==arr[i]){
                System.out.println("第"+i+"个候选人票数最多，共计"+arr[i]+"张票");
            }
        }
        //6统计弃票数和弃票率
        System.out.println("弃票数是"+arr[0]+"，弃票率是"+arr[0]*1.0/1000*100+"%");
    }
}
