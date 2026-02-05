package com.njx.topic1;

public class Test4 {
    public static void main(String[] args) {
        //接雨水   难，中大厂考题  动态规划
        //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
        //输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]输出：6
        //解释: 下面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下， 可以接 6个单位的雨水 （蓝色部分表示雨水）


        //1定义数组
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};

        //2从左向右遍历，记录雨水加柱子面积总和
        //2.1定义数组记录从左向右看的数据
        int [] leftMax=new int[arr.length];
        //2.2定义第三方变量temp，记录最高柱子
        int temp=arr[0];
        //2.3从左向右遍历
        for (int i = 0; i < arr.length; i++) {
            if(temp>arr[i]){
                leftMax[i]=temp;
            }else{
                leftMax[i]=arr[i];
                temp=arr[i];
            }
        }
        //3从右向左遍历，记录雨水加柱子面积总和
        int [] rightMax=new int[arr.length];
        temp=arr[arr.length-1];
        for (int i = arr.length-1; i >=0; i--) {
            if(temp>arr[i]){
                rightMax[i]=temp;
            }else{
                rightMax[i]=arr[i];
                temp=arr[i];
            }
        }
        //4取交集
        int[] result=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            if(leftMax[i]< rightMax[i]){
                result[i]=leftMax[i];
            }else{
                result[i]=rightMax[i];
            }
        }
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=result[i]-arr[i];
        }
        System.out.println(sum);
    }
}
