package com.njx.leetcode.Hot100;
import java.util.*;

//3. 无重复字符的最长子串
//这是一个滑动窗口题，并且用得到hashset的知识，难度不大
public class Solutions3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // 如果重复，就缩小窗口
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
