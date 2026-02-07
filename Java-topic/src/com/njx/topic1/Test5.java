package com.njx.topic1;

import java.util.Scanner;

import java.util.Random;

public class Test5 {
    public static void main(String[] args) {
        //彩票规则：
        //前区：1～35选5个号码（唯一）后区：1～12选2个号码（唯一）跨区可重复
        //中奖规则：
        //一等奖：5+2
        //二等奖：5+1
        //三等奖：5＋0/4+2四等奖：4+1 / 3+ 2
        //五等奖：4+0/ 3+1/ 2+ 2
        //六等奖:3+0/1+2/2+1/0+2

        //1利用Random随机生成彩票号码
        int [] lotteryNumber =createLotterynumber();
        printLotteryNumber(lotteryNumber);

        //2利用scanner模拟购买彩票
        int [] myLotteryNumber=buyLotteryNumber();
        printLotteryNumber(myLotteryNumber);

        //3判断中奖情况
        //判断中几个前区
        //判断中几个后区
        getWinnerNumber(lotteryNumber,myLotteryNumber);

    }

    //判断arr2中数据，在arr1中出现几次
    //arr1真正号码
    //arr2用户购买的彩票

    public static void getWinnerNumber(int[] arr1,int[] arr2)  {
        //判断前区
        int count1 = getCount(arr1, arr2, 0, 4);
        //判断后区
        int count2 = getCount(arr1, arr2, 5, 6);

        //判断中奖情况
        if(count1==5&&count2==2){
            System.out.println("恭喜中奖了，一等奖！");
        }else if(count1==5&&count2==1){
            System.out.println("恭喜中奖了，二等奖！");
        } else if (count1==4&&count2==2||count1==5&&count2==0) {
            System.out.println("恭喜中奖了，三等奖！");
        } else if (count1==4&&count2==1||count1==3&&count2==2) {
            System.out.println("恭喜中奖了，四等奖！");
        } else if (count1 == 3 && count2 == 0 || count1 == 3 && count2 == 1 || count1 ==2 && count2 == 2) {
            System.out.println("恭喜中奖了，五等奖！");
        }else if(count1==3&&count2==0||count1==2&&count2==1||count1==1&&count2==2||count1==0&&count2==2){
            System.out.println("恭喜中奖了，六等奖！");
        }else{
            System.out.println("未中奖！");
        }
    }

    //判断前区或后区中了几个求
    public static int getCount(int[] arr1,int[] arr2,int start,int end){
        int count = 0;

        for (int i = start; i <= end; i++) {
            boolean flag = contains(arr2[i], arr1, 0, 4);
            //如果当前数字已存在，表示中了一个
            if(flag){
                count++;
            }
        }
        //当循环结束就知道中的号码个数
        return count;
    }

    public static int[] buyLotteryNumber() {
        //1创建数组
        int[] arr = new int[7];

        //2利用scanner模拟购买彩票，1-35选五个（唯一）
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; ) {
            System.out.println("请输入第" + (i + 1) + "个前区号码（1-35）：");
            int number = scanner.nextInt();
            //范围
            if(number<1||number>35){
                System.out.println("输入的号码超出范围，请重新输入：");
                continue;
            }
            //判断是否唯一
            boolean flag = contains(number, arr, 0, 4);
            if(flag){
                System.out.println("该号码已存在，请重新输入：");
                continue;
            }
            //如果代码能运行到这里，说明输入的号码是合法的
            arr[i]=number;
            i++;
        }
        
        //3输入后区号码（1-12选两个唯一）
        for (int i = 5; i < 7; ) {
            System.out.println("请输入第" + (i - 4) + "个后区号码（1-12）：");
            int number = scanner.nextInt();
            //范围
            if(number<1||number>12){
                System.out.println("输入的号码超出范围，请重新输入：");
                continue;
            }
            //判断是否唯一
            boolean flag = contains(number, arr, 5, 6);
            if(flag){
                System.out.println("该号码已存在，请重新输入：");
                continue;
            }
            //如果代码能运行到这里，说明输入的号码是合法的
            arr[i]=number;
            i++;
        }
        
        scanner.close();
        return arr;
    }
    
    public static int[] createLotterynumber() {
        //1创建数组
        int[] arr = new int[7];

        //利用Random随机生成前区五个1～35的随机数，并保存在数组中
        Random r = new Random();
        for (int i = 0; i < 5; ) {
            int number = r.nextInt(1,36);
            boolean flag = contains(number, arr, 0, 4);
            if(! flag){
                arr[i] = number;
                i++;
            }
        }

        //利用Random随机生成后区两个1～12的随机数，1-12 并保存在数组中
        for (int i = 0; i < 2; ) {
            int number = r.nextInt(1,13);
            boolean flag = contains(number, arr, 5, 6);
            if(! flag){
                arr[i+5] = number;
                i++;
            }
        }
        return arr;
    }
    public static boolean contains(int number,int[] arr,int start,int end)
    {
        for (int i = start; i <= end; i++) {
            if(arr[i]==number)
            {
                return true;
            }
        }
        return false;
    }

    public static void printLotteryNumber(int[] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + "、");
            }
        }
        System.out.println("]");
    }


}

