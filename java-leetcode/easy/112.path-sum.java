/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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

 /*
  * clarify: starting from root, travse left and right subtree recursivly, until the path of sum is equal to targetSum
  the path must be root to leaf.
    * solution:
    step1: recursively call the left and right subtree
    step2: record the prefix sum 
    step3L use boolean to record the result
    step4: return eitehr left or right when is true
    
    base case: root equal null and targetSum == 0
    recursion rule: call left and right subtree, and - targetSum
    
    time: O(n)
    space: O(height)

  */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case
        if (root == null){
            return false;
        }
        return helper(root, targetSum, 0);
    }
    private boolean helper(TreeNode root, int targetSum, int prefixSum){
        if (root == null) return false;

        prefixSum += root.val;

        if (root.left == null && root.right == null && prefixSum == targetSum){
            return true;
        }
        boolean left = helper(root.left, targetSum, prefixSum);
        boolean right = helper(root.right, targetSum, prefixSum);

        if (left == true){
            return left;
        } else{
            return right;
        }
    }
}
   
// @lc code=end

