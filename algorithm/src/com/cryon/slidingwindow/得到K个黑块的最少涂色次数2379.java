package com.cryon.slidingwindow;

/**
 * @author iimer
 * @description
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。
 * 字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 *
 * 提示：
 *
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 *
 * @date 2023-03-09 11:25:19
 */
public class 得到K个黑块的最少涂色次数2379 {
    public int minimumRecolors(String blocks, int k) {
        final char[] bs = blocks.toCharArray();
        int nowNum = 0;
        for (int i = 0; i < k; i++) {
            if (bs[i] == 'W') {
                nowNum +=1;
            }
        }
        int res = nowNum;
        for (int i = k; i < bs.length; i++) {
            if (bs[i] == 'W') {
                nowNum+=1;
            }
            if (bs[i-k] == 'W'){
                nowNum-=1;
            }
            res = Math.min(nowNum,res);
        }
        return res;
    }
}
