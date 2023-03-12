package com.cryon.recurrence.dfs.tree;

/**
 * @author qgyiimer
 * @description 给定一棵二叉树，你需要计算它的直径长度。
 *              一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *              注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @create 2023-{03}--21:54
 */
public class 二叉树的直径543 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = Math.max(dfs(root),max);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        final int left = dfs(root.left);
        final int right = dfs(root.right);
        max = Math.max(left+right+2,max);
        return Math.max(left,right) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
