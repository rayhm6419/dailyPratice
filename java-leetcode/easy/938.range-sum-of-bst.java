/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //coner case
        if (root == null){
            return 0;
        }
        int[] sum = new int[1];
        helper(root, low, high, sum);
        return sum[0];
    }
    private void helper(TreeNode root, int low, int high, int[] sum){
        //base case
        if (root == null){
            return;
        }
        //收集解
        if (root.val >= low && root.val <= high){
            sum[0] += root.val;
        }
        /* 不需要写if，只要不在范围内，就左右recursion  call， 到了null自然会返回
        if (root.val < low){
            helper(root.left, low, high, sum);
        }
        if (root.val > high){
             helper(root.right, low, high, sum);
        }
        */
        helper(root.left, low, high, sum);
        helper(root.right, low, high, sum);
    }
}

/**
base case: 遇到null，返回0
recursion：左右找，并且维护一个sum
answer：
root > low -> go right -> 检查是否比high小
root < high -> go right -> 还没超过high，检查是否大于low

sub-problem:
root < low -> go right -> 比low还小，超出范围
root > high -> go left ->已经超过high， 往小的找

time: O(n)
space: O(height)
*/

