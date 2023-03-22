package com.cryon.dynamicprogramming;

/**
 * @author iimer
 * @description 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]
 *
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * @date 2023-03-22 18:37:31
 */
public class 跳跃游戏II45 {
    /*
    分析：dp[i] 代表 i位置的最小跳跃次数
    dp[i]=min(0~i-1位置中可以一步到达i的位置j,dp[j])+1
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 10000;
            for (int j = 0; j < i; j++) {
                if (nums[j]+j>=i) {
                    dp[i] = Math.min(dp[j]+1,dp[i]);
                }
            }
        }
        return dp[nums.length-1];
    }
}
