package com.njx.topic2;
/*
* 你有一张某海域
N
x
N
NxN 像素的照片，"."表示海洋、"#"表示陆地，如下所示：

.......

.##....

.##....

....##.

..####.

...###.

.......

其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有 2 座岛屿。

由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。

例如上图中的海域未来会变成如下样子：

.......

.......

.......

.......

....#..

.......

.......

请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
* 这道题的意思就是除了中心点（即四周都有陆地#）的岛屿，其他岛屿都是被水淹没的
* */
import java.util.*;
// 引入 Java 工具包，主要用 Scanner 读输入

public class Test3 {

    // 地图大小 N
    static int N;

    // 地图本身：'.' 海洋，'#' 陆地
    static char[][] g;

    // 访问标记数组，vis[x][y] = true 表示这个位置已经处理过
    static boolean[][] vis;

    // 四个方向：下、上、右、左（上下左右）
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    /*
     * 这个变量非常重要！
     * 表示：当前正在搜索的这“一整座岛”
     * 是否会被【完全淹没】
     *
     * true  ：目前看起来这座岛会全部消失
     * false ：发现了“内陆点”，这座岛不会全没
     */
    static boolean willDisappear;

    /**
     * 深度优先搜索 DFS
     * 从 (x, y) 出发，把整座岛的所有陆地都走一遍
     */
    static void dfs(int x, int y) {

        // 标记当前这个陆地已经访问过
        vis[x][y] = true;

        // ----------- 判断当前点是不是“内陆点” -----------

        /*
         * 先假设它是内陆点
         * 如果发现四个方向中有海洋，就推翻这个假设
         */
        boolean inner = true;

        // 检查上下左右四个方向
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 只要有一个方向是海洋
            if (g[nx][ny] == '.') {
                inner = false; // 不是内陆点
                break;
            }
        }

        /*
         * 如果 inner == true
         * 说明这个点上下左右全是陆地
         * → 它不会被淹没
         * → 整座岛“不可能完全消失”
         */
        if (inner) {
            willDisappear = false;
        }

        // ----------- 继续 DFS 搜索整座岛 -----------

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 如果相邻位置是陆地，并且还没访问过
            if (!vis[nx][ny] && g[nx][ny] == '#') {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 读入地图大小 N
        N = sc.nextInt();

        // 初始化地图和访问数组
        g = new char[N][N];
        vis = new boolean[N][N];

        // 读入地图
        for (int i = 0; i < N; i++) {
            g[i] = sc.next().toCharArray();
        }

        // 最终答案：会被完全淹没的岛屿数量
        int ans = 0;

        // 枚举地图上的每一个位置
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                /*
                 * 如果：
                 * 1. 这里是陆地 '#'
                 * 2. 之前没有访问过
                 *
                 * 那么说明：发现了一座“新岛屿”
                 */
                if (g[i][j] == '#' && !vis[i][j]) {

                    // 先假设这座岛会被完全淹没
                    willDisappear = true;

                    // 用 DFS 把整座岛搜完
                    dfs(i, j);

                    /*
                     * 如果 DFS 完成后
                     * willDisappear 仍然是 true
                     * 说明：岛里没有任何一个“内陆点”
                     * → 整座岛会完全消失
                     */
                    if (willDisappear) {
                        ans++;
                    }
                }
            }
        }

        // 输出答案
        System.out.println(ans);
    }
}
