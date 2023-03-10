package com.cryon.base.hash;

/**
 * @author iimer
 * @description 给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
 *
 *              按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
 *
 *              0 <= i < nums.length
 *              0 <= j < nums.length
 *              0 <= k < nums.length
 *              nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
 *
 *
 *              1 <= nums.length <= 1000
 *              0 <= nums[i] < 216
 * @date 2023-03-06 19:39:46
 */
public class 按位与为零的三元组982 {
    /*
        分析:
        1、暴力法，枚举所有值，时间复杂度O(n^3)
        2、空间换时间
           三个数&运算为0，也可以说是一个数和另两个数的&的结果进行&运算，不必关心另外两个数分别是什么，也就不需要n*n^2
           存储两个数的&的每个可能性的个数，再遍历最后一个数来判断即可
           2.1 时间复杂度O(n^2+n*2^16)
           2.2

     */
    public int countTriplets(int[] nums) {
        int cnt = nums.length;
        int[] cntCache = new int[1<<16];
        int res = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                cntCache[nums[i] & nums[j]]++;
            }
        }
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 1 << 16; j++) {

            }
        }
        return res;
    }
}
