/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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

 //given two binary trees, write a function to check if they are the same or not.
 //two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 //tiem: O(n) - traverse all nodes
//space: O(n) - the size of the stack in the worst case will be O(n), where n is the number of nodes in the tree.

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            //the frist condition and the second conditon order are matter.
            //if the first condition is false, the second condition will not be executed.
            if (p == null && q == null){
                return true;
            }
            if (p == null || q == null){
                return false;
            }
            if (p.val != q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
// @lc code=end

