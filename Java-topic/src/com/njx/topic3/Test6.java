package com.njx.topic3;

import java.util.*;
//九重迷宫，本质上是bfs
public class Test6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String start = scan.next();//初始状态
        String end = scan.next();//目标状态
        int res = bfs(start,end);//使用的步数，走不通返回-1
        System.out.println(res);
        scan.close();
    }
    //广度优先遍历
    public static int bfs(String start, String end) {
        Queue<String> queue = new LinkedList<String>();//创建队列
        queue.add(start);//加入初始状态
        Map<String,Integer> map = new HashMap<>();//存放每一步对应的状态，或者说每个状态对应的步数，哎呀差不多
        map.put(start,0);//初始状态，对应0步

        int[] d = {-3,3,-1,1};//上下左右的偏移量

        while (!queue.isEmpty()) {
            String cur = queue.poll();//弹出队列头的状态
            int step = map.get(cur);//当前的步数
            int blankPos = cur.indexOf('.');//找空格的位置，就是'.'的位置

            //上下左右都走一遍，找出下一步的所有状态
            for (int i = 0; i < 4; i++) {
                int newPos = blankPos + d[i];//空格的新位置
                //判断新位置是否合法
                if (newPos < 0 || newPos >= 9 || (blankPos % 3 != newPos % 3 && blankPos / 3 != newPos / 3)){
                    //说明位置不合法，直接进行下一次循环
                    continue;
                }
                //如果位置合法就把空格移动到新位置
                char[] chars = cur.toCharArray();
                chars[blankPos] = chars[newPos];
                chars[newPos] = '.';
                String newState = new String(chars);
                if (newState.equals(end)) {
                    //如果新的状态就是目标状态返回当前步数加1
                    return step + 1;
                }

                //如果不是就存放当前状态，继续往后找
                if (!map.containsKey(newState)) {
                    queue.add(newState);
                    map.put(newState,step + 1);
                }
            }
        }
        return -1;//代码执行到这，说明找不zhuo了
    }
}

