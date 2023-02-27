package com.cryon.greedy.array;

/**
 * @author iimer
 * @date 2023-02-27 11:42:43
 */
public class 递减元素使数组呈锯齿状1144 {
    public static void main(String[] args) {
        movesToMakeZigzag(new int[]{1,2,3});
    }

    public static int movesToMakeZigzag(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int evenSum = Math.max(nums[1]-nums[0]+1,0);
        int oddSum = Math.max(nums[2]-nums[1]+1,0)+Math.max(nums[0]-nums[1]+1,0);
        for (int i = 2; i < nums.length; i++) {
            int tmpRight;
            if (i != nums.length-1) {
                tmpRight = Math.max(nums[i+1]-nums[i]+1,0);
            } else {
                tmpRight = 0;
            }
            int tmpLeft = Math.max(Math.max(nums[i-1]-nums[i]+1,0)-Math.max(nums[i-1]-nums[i-2]+1,0),0);
            int tmpSum =tmpRight + tmpLeft;
            //偶数
            if (i % 2 == 0) {
                evenSum += tmpSum;
            } else {
                oddSum += tmpSum;
            }
        }
        return Math.min(evenSum,oddSum);
    }
}
