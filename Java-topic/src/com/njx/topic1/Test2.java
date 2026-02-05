package com.njx.topic1;

public class Test2 {
    public static void main(String[] args) {
        //中位数
        //给定两个正序数组 arr1和 arr2，请先合并数组，并找出合并之后数组的中位数。
        // 举例:123456789
        //中位数：5
        //123456
        //中位数：
        //（3+4）/ 2

        //定义两个数组
        int arr1[]={1,3,5,7,9};
        int arr2[]={2,4};

        double number=findmedianarray(arr1,arr2);
        System.out.println(number);
    }
    public static double findmedianarray(int[] arr1,int[] arr2)
    {
        //将arr1与arr2合并
        //1.定义一个大数组
        int[] arr=new int [arr1.length+arr2.length];
        //保证正序
        //暴力不管顺序，先放入数据在排序
        //思路简单但是效率低

        //快捷思路一边添加一边排序
        //前提arr1和arr2都是正序的

        //2定义两个变量，充当箭头
        int index1=0;
        int index2=0;

        //遍历
        for (int i = 0; i < arr.length; i++) {
            //若arr1短
            if(index1==arr1.length){
                arr[i]=arr2[index2];
                index2++;
                continue;
            }
            //若arr2短
            if(index2==arr2.length){
                arr[i]=arr[index1];
                index1++;
                continue;
            }
            //判断index1与index2指向的数谁小，添加谁
            if(arr1[index1]<arr2[index2]){
                arr[i]=arr1[index1];
                index1++;
            }else{
                arr[i]=arr2[index2];
                index2++;
            }
        }
        //求中位数
        //判断奇数偶数

        //元素 1 2 3 4 5 6
        //索引 0 1 2 3 4 5
        if (arr.length%2==0){
            int num1=arr[arr.length/2];
            int num2=arr[arr.length/2-1];
            return (num1+num2)/2.0;
        }else{
            int num=arr[arr.length/2];
            return num;
        }
    }
}
