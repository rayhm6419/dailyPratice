/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //coner case
        if (root == null){
            return res;
        }
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
// @lc code=end

