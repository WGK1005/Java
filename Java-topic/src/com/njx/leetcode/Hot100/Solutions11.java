package com.njx.leetcode.Hot100;

public class Solutions11 {
    public int maxArea(int[] height) {
        int left = 0;                     // 左指针
        int right = height.length - 1;    // 右指针
        int max = 0;                      // 记录最大面积

        while (left < right) {

            // 计算当前面积
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            max = Math.max(max, area);

            // 移动短边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
//双指针的迫敛题型，模板已经总结到语雀