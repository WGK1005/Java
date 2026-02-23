package com.njx.leetcode.Hot100;

import java.util.*;

public class Solutions560 {
    public int subarraySum(int[] nums, int k) {

        // 统计满足条件的子数组个数
        int count = 0;

        // 当前的前缀和
        int prefixSum = 0;

        // key: 前缀和
        // value: 该前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();

        // 前缀和为0默认出现一次
        // 处理从下标0开始的子数组
        map.put(0, 1);

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {

            // 更新当前前缀和
            prefixSum += nums[i];

            // 目标：找是否存在 prefixSum - k
            int target = prefixSum - k;

            if (map.containsKey(target)) {

                // 找到多少次，就说明有多少个子数组
                count += map.get(target);
            }

            // 更新当前前缀和出现次数
            if (map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return count;
    }
}
