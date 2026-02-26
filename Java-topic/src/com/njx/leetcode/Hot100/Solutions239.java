package com.njx.leetcode.Hot100;

import java.util.*;

public class Solutions239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // 双端队列，存储的是数组下标
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. 移除窗口左边已经过期的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
                //deque是一个接口，在就接口中定义了以下四种方式用于删除队列元素
                // pollFirst()
                //pollLast()
                //removeFirst()
                //removeLast()
            }

            // 2. 保持队列单调递减（队尾小的全部弹出）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. 当前下标加入队列
            deque.offerLast(i);

            // 4. 当窗口形成后开始记录答案
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
