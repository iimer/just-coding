package com.cryon.recurrence.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qgyiimer
 * @description
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * @create 2023-{03}--21:13
 */
public class 子集78 {
    /**
     * 枚举回溯
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        bt(nums,tmp,res,0);
        return res;
    }

    private void bt(int[] nums, List<Integer> tmp, List<List<Integer>> res,int j) {
        for (int i = j; i < nums.length; i++) {
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            bt(nums,tmp,res,i+1);
            tmp.remove(tmp.size()-1);
        }
    }


    /**
     * 选还是不选
     */
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets2(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        // 不选 nums[i]
        dfs(i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
}
