package com.cryon.dynamicprogramming;

/**
 * @author iimer
 * @description
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * @date 2023-03-08 14:58:11
 */
public class 礼物的最大价值剑指Offer47 {
    /*
    分析：每个格子的价值的非规则性导致不能使用贪心算法，需要用动态规划。
    状态转移方程:dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j]
    特殊位置：
        (1)、dp[0][j] = dp[0][j-1]+grid[0][j]
        (2)、dp[i][0] = dp[i-1][0]+grid[i][0]
     */
    public int maxValue(int[][] grid) {
        int[][] maxDp = new int[grid.length][grid[0].length];
        maxDp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            maxDp[i][0] = maxDp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            maxDp[0][i] = maxDp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                maxDp[i][j] = Math.max(maxDp[i-1][j],maxDp[i][j-1])+grid[i][j];
            }
        }
        return maxDp[grid.length-1][grid[0].length-1];
    }
}
