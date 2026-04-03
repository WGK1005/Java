package com.njx.Basic7;

import java.util.*;

/**
 * 等差数列计数问题
 * 
 * 题目描述:
 * 等差数列是一种任意相邻两项的差均为固定常数 (公差) 的数列。
 * 例如:{1, 3, 5} 是公差为 2 的等差数列，{2, 3, 5} 不是等差数列。
 * 
 * 问题：从 1 到 2025 的整数中选取 3 个不同的数，问可以组成多少种不同的、长度为 3 的等差数列？
 * 两个等差数列不同当且仅当它们至少有一项不同。
 * 例如:{1, 2, 3} 和 {2, 3, 4} 是不同的，{1, 2, 3} 和 {3, 2, 1} 也是不同的。
 * 
 * 解题思路:
 * 对于长度为 3 的等差数列 {a, b, c},设公差为 d,则:
 * - 当 d > 0 时：a < b < c
 * - 当 d < 0 时：a > b > c  
 * - 当 d = 0 时：a = b = c (不符合"3 个不同的数"的要求，排除)
 * 
 * 算法核心:
 * 1. 枚举中间项 b (范围：2 到 2024)
 * 2. 对于每个 b,计算可以作为第一项 a 的数量 (left = b - 1)
 * 3. 计算可以作为第三项 c 的数量 (right = max - b)
 * 4. 能组成的正公差数列数 = min(left, right)
 * 5. 最终结果 = 正公差数列数 × 2 (包含正公差和负公差两种情况)
 */
public class Test2 {
    public static void main(String[] args) {
        // 最大数值范围
        int max = 2025;
        
        // 用于统计公差为正的等差数列数量
        long ascendingCount = 0;
        
        // 遍历所有可能的中间项 b (从 2 到 max-1)
        // 对于长度为 3 的等差数列 {a, b, c},b 是中间项
        for (int b = 2; b < max; b++) {
            // 计算 b 左边可选的数字数量 (即 a 的选择数，a < b)
            int left = b - 1;
            
            // 计算 b 右边可选的数字数量 (即 c 的选择数，c > b)
            int right = max - b;
            
            // 对于固定的中间项 b，能组成的等差数列数量为 min(left, right)
            // 因为要同时满足 a = b - d 和 c = b + d 都在 [1, max] 范围内
            ascendingCount += Math.min(left, right);
        }
        
        // 总数量 = 正公差数列数 × 2
        // 因为每个正公差的等差数列 {a, b, c} 都对应一个负公差的等差数列 {c, b, a}
        long total = ascendingCount * 2;
        
        // 输出结果
        System.out.println(total);
    }
}
