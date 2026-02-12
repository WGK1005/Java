import java.util.*;

//很久以前，T王国空前繁荣。为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。
//为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。
//J是T国重要大臣，他巡查于各大城市之间，体察民情。所以，从一个城市马不停蹄地到另一个城市成了」最常做的事情。他有一个钱袋，用于存放往来城市间的路费。
//聪明的」发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，在走第×千米到第α+1 千米这一千米中（∞ 是整数），他花费的路费是α+10 这么多。也就是说走 1 千米花费 11， 走 2 千米要花费 23。
//J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？
//输入描述
//输入的第一行包含一个整数n，表示包括首都在内的T 王国的城市数。
//城市从 1开始依次编号，1号城市为首都。
//接下来 n -1 行，描述 T 国的高速路（ T 国的高速路一定是  -1条）。
//每行三个整数 P,Q,D，表示城市 P 和城市 Q 之间有一条高速路，长度为 D 千米。

public class Test7 {

    /*
     * Edge 类表示一条边
     * to  表示这条边连接到哪个城市
     * w   表示这条边的长度（多少千米）
     */
    static class Edge {
        int to, w;

        Edge(int t, int w) {
            this.to = t;
            this.w = w;
        }
    }

    // 邻接表存图
    static List<Edge>[] graph;

    // 当前找到的最大距离（用于求直径）
    static long maxDist = 0;

    // 当前距离最远的节点
    static int farNode = 1;

    /*
     * DFS函数
     * u      当前节点
     * parent 父节点（防止往回走）
     * dist   从起点到当前节点的距离
     */
    static void dfs(int u, int parent, long dist) {

        // 如果当前距离比记录的最大距离大
        // 就更新最大距离
        if (dist > maxDist) {
            maxDist = dist;
            farNode = u;  // 记录最远的节点
        }

        // 遍历当前节点的所有邻居
        for (Edge e : graph[u]) {

            // 防止走回父节点
            if (e.to != parent) {

                // 递归搜索下一个节点
                // 距离加上当前边的长度
                dfs(e.to, u, dist + e.w);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 城市数量
        int n = sc.nextInt();

        // 初始化邻接表
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 读入 n-1 条边
        for (int i = 0; i < n - 1; i++) {

            int p = sc.nextInt();  // 城市p
            int q = sc.nextInt();  // 城市q
            int d = sc.nextInt();  // 两城市之间的距离

            // 因为是无向图，所以要加两次
            graph[p].add(new Edge(q, d));
            graph[q].add(new Edge(p, d));
        }

        /*
         * 第一次DFS：
         * 从任意点（这里从1号城市）开始
         * 找到离它最远的城市 A
         */
        dfs(1, 0, 0);

        // 记录这个最远点
        int start = farNode;

        /*
         * 第二次DFS：
         * 从刚才找到的最远点 A 开始
         * 找到离 A 最远的点 B
         * A到B的距离就是树的直径
         */
        maxDist = 0;  // 记得清零
        dfs(start, 0, 0);

        // 树的直径长度
        long L = maxDist;

        /*
         * 根据题目：
         * 第1公里花11
         * 第2公里花12
         * ...
         * 第L公里花(10 + L)
         *
         * 总花费 = 10L + L(L+1)/2
         *        = (L^2 + 21L) / 2
         */
        long result = (L * L + 21 * L) / 2;

        System.out.println(result);
    }
}
//实际上还是DP问题但是我还是不太懂，所以得看看视频