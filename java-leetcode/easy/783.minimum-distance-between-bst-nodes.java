/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] min = new int[]{Integer.MAX_VALUE};
        TreeNode[] prev = null;
        helper(root, min, prev);
        return min[0];
    }
    private void helper(TreeNode root, int[] min, TreeNode[] prev){
        if (root == null){
            return;
        }
        helper(root.left, min, prev);
        if (prev != null){
            min[0] = Math.min(min[0], root.val - prev[0].val);
        }
        prev[0] = root;
        helper(root.right, min, prev);
    }
}
// @lc code=end

