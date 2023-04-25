/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
/**
 inOrder traversal, 
 如果找到leaf node，说明是最深
 记录左和右的最深距离
 最后返回左或右最长的距离
  */
  class Solution {
    int D = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }

        helper(root); 
        return D;
    }
    private int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left);

        int right = helper(root.right);

        // Update the diameter with the current node as the highest node in the path
        D = Math.max(D, left + right);

        // Return the height of the subtree rooted at the current node
        return Math.max(left, right) + 1;

    }
}
