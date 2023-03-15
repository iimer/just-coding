package com.cryon.recurrence.backtracking.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qgyiimer
 * 给你 n 个城市，编号为从 1 到 n 。
 * 同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。
 * 题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。
 *
 * 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。
 * 两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
 *
 * 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。
 *
 * 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。
 *
 * 请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 *
 * 提示：
 *
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 题目保证 (ui, vi) 所表示的边互不相同。
 *
 * @create 2023-{03}--23:10
 */
public class 统计子树中城市之间最大距离1617 {
    /**
     * 灵神
     */
    private List<Integer>[] g;
    private boolean[] inSet, vis;
    private int[] ans;
    private int n, diameter;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始
            g[x].add(y);
            g[y].add(x); // 建树
        }

        ans = new int[n - 1];
        inSet = new boolean[n];
        f(0);
        return ans;
    }

    private void f(int i) {
        if (i == n) {
            for (int v = 0; v < n; ++v)
                if (inSet[v]) {
                    vis = new boolean[n];
                    diameter = 0;
                    dfs(v);
                    break;
                }
            if (diameter > 0 && Arrays.equals(vis, inSet))
                ++ans[diameter - 1];
            return;
        }

        // 不选城市 i
        f(i + 1);

        // 选城市 i
        inSet[i] = true;
        f(i + 1);
        inSet[i] = false; // 恢复现场
    }

    // 求树的直径
    private int dfs(int x) {
        vis[x] = true;
        int maxLen = 0;
        for (int y : g[x])
            if (!vis[y] && inSet[y]) {
                int ml = dfs(y) + 1;
                diameter = Math.max(diameter, maxLen + ml);
                maxLen = Math.max(maxLen, ml);
            }
        return maxLen;
    }
}
