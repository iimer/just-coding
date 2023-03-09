package com.cryon.slidingwindow.core;

import java.util.LinkedList;

/**
 * @author iimer
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *              你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * @date 2023-03-01 16:18:12
 */
public class 滑动窗口最大值239 {
    /**
     * 优先队列解法
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        return null;
    }

    /**
     * 单调队列
     * 选用队列的原因：具有进来的顺序的特性，滑动窗口右移时，最左侧的一定是最先进入队列的
     * 单调的原因：需要得到每个窗口的最大值，单调递减则可以保证第一个为最大值。
     *            保证单调会提前淘汰掉一些元素，但这些元素此时都是无意义的（不会成为当前窗口的最大值）。
     * 总结：十分适合滑动窗口的最值问题。
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            while (q.size() > 0 && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
        }
        res[0] = nums[q.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (q.peekFirst() == i-k) {
                q.pollFirst();
            }
            while (q.size() > 0 && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            res[i-k+1] = nums[q.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        maxSlidingWindow2(new int[]{1,3,1,2,0,5},3);
    }
}
