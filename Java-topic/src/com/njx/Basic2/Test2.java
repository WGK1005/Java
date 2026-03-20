package com.njx.Basic2;

import java.util.*;
//超时了，但是这是最简单的方式了。
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // t组数据

        while (t-- > 0) {

            // 用 HashMap 统计每种职业的人数
            HashMap<Integer, Integer> map = new HashMap<>();

            int n = sc.nextInt();
            int k = sc.nextInt();

            int cnt = 0; // 当前最多能组成的组数

            // 读入
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt(); // 职业
                int b = sc.nextInt(); // 人数

                map.put(a, map.getOrDefault(a, 0) + b);
            }

            // 计算最多能组成多少组
            for (int val : map.values()) {
                cnt += val / 3;
            }

            // 如果不够
            if (cnt < k) {
                System.out.println(-1);
                continue;
            }

            // 转成数组并排序（从大到小）
            ArrayList<Integer> list = new ArrayList<>(map.values());
            list.sort((a, b) -> b - a);

            int ans = 0;

            for (int i = 0; i < list.size(); i++) {
                int d = list.get(i);

                if (k > 0) {

                    // 情况1：当前职业可以直接满足k组
                    if (d / 3 >= k) {
                        ans += 3 * k - 1; // 最坏情况
                        k = 1; // 还需要再补一组
                    }

                    // 情况2：不足3人
                    else if (d < 3) {
                        ans += d;
                    }

                    // 情况3：正常处理
                    else {
                        if (d % 3 == 0) {
                            ans += d - 1;
                            k -= (d / 3 - 1);
                        } else if (d % 3 == 1) {
                            ans += d - 2;
                            k -= (d / 3 - 1);
                        } else if (d % 3 == 2) {
                            ans += d;
                            k -= (d / 3);
                        }
                    }
                }
            }

            // 最后 +1（补齐最后一组）
            System.out.println(ans + 1);
        }
    }
}
/*
在蓝桥王国，国王统治着一支由 n 个小队组成的强大军队。每个小队都由相同职业的士兵组成。具体地，第个小队包含了 b 名职业为a的士兵。
近日，国王计划在王宫广场举行一场盛大的士兵检阅仪式，以庆祝王国的繁荣昌盛。然而，在士兵们入场的过程中，一场突如其来的风暴打乱了他们的行列，使得不同小队的士兵混杂在一起，次序乱成一团，
尽管国王无法知道每个士兵的具体职业，但为了确保仪式能顺利进行，国王打算从这些混乱的士兵中选出一部分，组成k 个"纯职业小组"进行检阅。一个"纯职业小组"定义为由 3名同职业的士兵组成的队伍。
请问，国王至少需要选择多少名士兵，才能确保这些士兵可以组成k 个“纯职业小组"。
输入格式
输入包含多组数据。
第一行包含一个整数T，表示有T 组数据。
对于每组数据：
·第一行包含两个整数 nt和k，表示小队的数量和要组成的纯职业小组的数量。
·接下来的 nt 行，每行包含两个整数 α 和 b，表示第 个小队中士兵的职业和数量。
输出格式
对于每组数据，输出一个整数，表示为了组成k个“纯职业小组”，国王至少需要选择的士兵数量。如果无论如何也无法组成 k 个"纯职业小组"，则输出 －1。
 */