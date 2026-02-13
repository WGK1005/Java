package com.njx.leetcode.Hot100;
import java.util.*;

public class Solutions128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // 1. 把所有数字放入 set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // 2. 遍历每个数字
        for (int num : set) {

            // 3. 如果 num-1 不存在，说明是起点
            if (!set.contains(num - 1)) {

                int nowNum = num;
                int nowLength = 1;

                // 4. 向后找连续数字
                while (set.contains(nowNum + 1)) {
                    nowNum++;
                    nowLength++;
                }

                maxLength = Math.max(maxLength, nowLength);
            }
        }

        return maxLength;
    }
}
