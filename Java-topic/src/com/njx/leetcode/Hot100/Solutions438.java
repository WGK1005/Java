package com.njx.leetcode.Hot100;
import java.util.*;

public class Solutions438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        //  统计 p 的字符频率
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            int index = c - 'a';
            pCount[index]++;
        }

        int left = 0;

        //  滑动窗口
        for (int right = 0; right < s.length(); right++) {

            // 加入右边字符
            sCount[s.charAt(right) - 'a']++;

            // 如果窗口大小超过 p.length，缩左边
            if (right - left + 1 > p.length()) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }

            // 如果两个数组相等 → 找到异位词
            if (Arrays.equals(pCount, sCount)) {
                result.add(left);
            }
        }

        return result;
    }
}
