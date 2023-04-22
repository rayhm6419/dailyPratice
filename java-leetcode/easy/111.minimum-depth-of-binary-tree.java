/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
  * clarify: starting from the root node, find the minimum depth of the tree
    *shortest path from the root node down to the nearest leaf node
    
    solution:
    step1: recursively call the left and right subtree
    step2: record the minimum depth using a global variable -> because left and right subtree may not be balanced
    step3: return the minimum depth

    base case: if the root is null, return 0
    recursion rule: call the left and right subtree

    time: O(n)
    space: O(height)
  */
  class Solution {
    public int minDepth(TreeNode root) {
        //base case
        if (root == null){
          return 0;
        }
        //condition: leaf node
        if (root.left == null && root.right == null){
          return 1;
        }
        int minimumDepth = Integer.MAX_VALUE;

        //if the left subtree is not null, then recursively call the left subtree
        if (root.left != null){
          minimumDepth = Math.min(minDepth(root.left), minimumDepth);
        }
        //if the right subtree is not null, then recursively call the right subtree
        if (root.right != null){
          minimumDepth = Math.min(minDepth(root.right), minimumDepth);
        }
        return minimumDepth + 1;
    }
}
// @lc code=end

