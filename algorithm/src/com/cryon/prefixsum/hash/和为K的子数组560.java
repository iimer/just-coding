package com.cryon.prefixsum.hash;

import java.util.HashMap;

/**
 * @author iimer
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * @date 2023-03-10 10:30:43
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class 和为K的子数组560 {
    public static int subarraySum(int[] nums, int k) {
        //多一位是因为遍历时会漏掉[0,i]这一条子数组的判断。
        //有了index为0的初始化操作，就不会漏掉了。
        int[] sums = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        HashMap<Integer,Integer> sum2num = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res+=sum2num.getOrDefault(sums[i]-k,0);
            sum2num.put(sums[i],sum2num.getOrDefault(sums[i],0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{1,1,1},2);
    }
}
