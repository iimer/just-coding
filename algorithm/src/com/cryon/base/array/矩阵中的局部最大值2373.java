package com.cryon.base.array;

/**
 * @author iimer
 * @date 2023-03-01 14:27:40
 */
public class 矩阵中的局部最大值2373 {
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int[][] res = new int[length-2][length-2];
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - 2; j++) {
                res[i][j] = getLocalNodeNum(grid,i,j);
            }
        }
        return res;
    }

    private int getLocalNodeNum(int[][] grid, int i, int j) {
        int max = 0;
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                max = Math.max(grid[ii+i][j+jj],max);
            }
        }
        return max;
    }
}
