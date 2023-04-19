/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
  * clarify:
  if the height of left and right subtree is > 1, then the tree is not Balanced.

    * solution:
    step1: find the height of the left and right subtree
    step2: if the height of left and right subtree is > 1, then the tree is not Balanced.
    step3: recursively call the left and right subtree
    step4: return true if the tree is balanced

    time: O(n)
    space: O(height)


  */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        //why need to check both left and right? 
        //because the tree is not balanced if any of the subtree is not balanced. keep checking until the leaf node.
        return isBalanced(root.left) && isBalanced(root.right); 
    }
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left,right) + 1;
    }
}
// @lc code=end
