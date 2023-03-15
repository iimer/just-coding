package com.cryon.base.graph;

import java.util.*;

/**
 * @author iimer
 * @description
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。
 * 每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。
 * 如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 *
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 *
 *
 * 提示：
 *
 * 2 <= n <= 100
 * 0 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 2
 * 0 <= ai, bi <= n-1
 * ai != bi
 * 每对城市之间 最多只有一条 道路相连
 * @date 2023-03-15 18:42:24
 */
public class 最大网络秩1615 {
    public static int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] ac = new HashSet[n];
        Arrays.setAll(ac,e->new HashSet());
        for (int i = 0; i < roads.length; i++) {
            ac[roads[i][0]].add(roads[i][1]);
            ac[roads[i][1]].add(roads[i][0]);
        }
        int resMax = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                resMax = Math.max(resMax,getMax(i,j,ac));
            }
        }
        return resMax;
    }

    private static int getMax(int i, int j, Set<Integer>[] ac) {
        return ac[i].size() + ac[j].size() + (ac[i].contains(j)?-1:0);
    }

    public static void main(String[] args) {
        int[][] ints = new int[4][2];
        ints[0][0] =  0;
        ints[0][1] =  1;
        ints[1][0] =  0;
        ints[1][1] =  3;
        ints[2][0] =  1;
        ints[2][1] =  2;
        ints[3][0] =  1;
        ints[3][1] =  3;
        maximalNetworkRank(4,ints);
    }

    /**
     * 用数组来替代hashset实现contains的判断。
     * 数据特殊，都是int且值不大且从0开始递增，所以代价很小，用数组来判断更快！
     * 因为在用hashSet的时候每次都需要计算hashcode等操作，浪费时间
     */
    public int maximalNetworkRank2(int n, int[][] roads) {
        boolean[][] g = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] road : roads) {
            int f = road[0], t = road[1];
            g[f][t] = g[t][f] = true;
            degree[f]++;
            degree[t]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = Math.max(ans, degree[i] + degree[j] - (g[i][j] ? 1 : 0));
            }
        }
        return ans;
    }
}
