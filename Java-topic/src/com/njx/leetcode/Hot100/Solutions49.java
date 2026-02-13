package com.njx.leetcode.Hot100;
import java.util.*;

//字母异位词分组
public class Solutions49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 转成字符数组
            char[] chars = str.toCharArray();

            // 排序
            Arrays.sort(chars);

            // 变回字符串
            String key = new String(chars);

            // 如果没有这个key，先创建list
            map.putIfAbsent(key, new ArrayList<>());

            // 加入原字符串
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
//哈希算法

