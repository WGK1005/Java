package com.njx.leetcode.Hot100;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 创建算法对象
        Solution1 solution = new Solution1();

        // 准备测试数据
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 调用方法
        int[] result = solution.twoSum(nums, target);

        // 打印结果
        System.out.println(Arrays.toString(result));
    }
}
