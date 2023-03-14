package com.cryon.greedy.array;

/**
 * @author iimer
 * @description
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。
 * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 *
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 *
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 *
 * 提示：
 *
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 108
 * sum(rowSum) == sum(colSum)
 * @date 2023-03-14 14:43:25
 */
public class 给定行和列的和求可行矩阵1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            if (rowSum[i] == 0) {
                continue;
            }
            for (int j = 0; j < colSum.length; j++) {
                ans[i][j] = Math.min(rowSum[i],colSum[j]);
                rowSum[i]-= ans[i][j];
                colSum[j]-= ans[i][j];
            }
        }
        return ans;
    }
}
