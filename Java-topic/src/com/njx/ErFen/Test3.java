package com.njx.ErFen;

import java.util.*;

import java.util.*;
//完全能通过但是难度较大。我的代码始终无法完全通过，或许时思路错了，但是这是国赛的题，先放了。
public class Test3 {
    private static int[][] intervals;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        intervals = new int[n][2];
        for (int i = 0; i < n; ++i) {
            intervals[i][0] = 2 * scan.nextInt(); // 方便起见，将区间长度翻倍，这样在计算时位移量就不用除2了，结果÷2即可
            intervals[i][1] = 2 * scan.nextInt();
        }
        scan.close();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        int left = 0, right = (int) 2e4;
        while (left < right) { // 二分查找，左闭右开版本
            int mid = (left + right) >> 1;
            if (check(mid)) right = mid;
            else left = mid + 1;
        }
        if (right % 2 == 0) System.out.println(right / 2);
        else System.out.println((double) right / 2);
    }

    // 难点：check函数 使用贪心思路（覆盖范围）
    private static boolean check(int shift) {
        int cover = 0;
        List<int[]> temp = new ArrayList<>(Arrays.asList(intervals)); // 逐个遍历，并排除掉合格的区间
        while (true) {
            boolean qualified = false;
            for (int i = 0; i < temp.size(); ++i) {
                int[] interval = temp.get(i);
                if (interval[0] - shift <= cover /* 此时的cover可以理解为前一个区间的覆盖范围，这里检测的是向左移动能不能够到前面的 */ && interval[1] + shift >= cover /* 区间最右点达到的位置不超过区间的最大右偏移量 */) {
                    qualified = true;
                    int len = interval[1] - interval[0];
                    if (interval[0] + shift >= cover) cover += len; // 如果当前区间左移后超过前面区间的覆盖范围，那么此次移动，覆盖范围最多只能增加当前区间本身的长度，否则不连续
                    else cover = interval[1] + shift; // 若不能超过，覆盖范围最多是当前区间末端+位移量
                    temp.remove(i);
                    break; // 删除后立刻到下一个循环，以免Concurrent Modification Exception（贪心循环外面套一个while true的原因）
                }
            }
            if (!qualified || cover >= 2e4) break;
        }
        return cover >= 2e4;
    }

}
/*public class Test3 {
    static int n;
    static double[] a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new double[n];
        b = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            b[i] = sc.nextDouble();
        }

        double left = 0;
        double right = 10000;

        // 二分答案
        for (int i = 0; i < 100; i++) {

            double mid = (left + right) / 2;

            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        double ans = right;

        // 输出
        if (Math.abs(ans - Math.round(ans)) < 1e-6) {
            System.out.println((long)Math.round(ans));
        } else {
            System.out.printf("%.1f\n", ans);
        }
    }
    static boolean check(double d) {

        double[][] seg = new double[n][3];

        // 计算区间长度和可移动范围
        for (int i = 0; i < n; i++) {

            double len = b[i] - a[i];

            seg[i][0] = a[i] - d; // 最左起点
            seg[i][1] = a[i] + d; // 最右起点
            seg[i][2] = len;      // 区间长度
        }

        // 按最左起点排序
        Arrays.sort(seg, (x, y) -> Double.compare(x[0], y[0]));

        double cur = 0;

        for (int i = 0; i < n; i++) {

            double L = seg[i][0];
            double R = seg[i][1];
            double len = seg[i][2];

            // 如果最早开始位置都在 cur 右边
            if (L > cur) return false;

            // 起点不能超过 R
            double start = Math.min(cur, R);

            cur = Math.max(cur, start + len);

            if (cur >= 10000) return true;
        }

        return cur >= 10000;
    }
}
*/



/*
数轴上有 n 个闭区间：D1,···Dn 。
其中区间 D; 用一对整数[α,b」 来描述，满足 α ≤ bo已知这些区间的长度之和至少有 104。
所以，通过适当的移动这些区间，你总可以使得他们的"并"覆盖
[0,104],也就是说[0,104] 这个区间内的每一个点都落于至少一个区间内。
你希望找一个移动方法，使得位移差最大的那个区间的位移量最小。
具体来说，假设你将 D; 移动到[α + Ci, b + Ci]这个位置。你希望使得max|C;最小。
输入描述
输入的第一行包含一个整数，表示区间的数量。
接下来有  行，每行 2 个整数 α,b，以一个空格分开，表示区间[α, b]。 保证区间的长度之和至少是 104。
其中,1≤n≤ 10，0≤α<b≤ 104。
输出描述
输出一个数字，表示答案。如果答案是整数，只输出整数部分。如果答案不是整数，输出时四舍五入保留一位小数。
 */