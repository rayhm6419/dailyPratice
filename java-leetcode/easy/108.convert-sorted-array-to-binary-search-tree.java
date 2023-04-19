/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
 * ascending order, so is in order traversal
 * the output is a treeNode, so we need to create a new node
 * the mid of the array is the root of the tree
 * the left side of the array is the left subtree
 * the right side of the array is the right subtree
 * 
 * solution:
 * step1: find the mid of the array
 * step2: create a new node with the mid value
 * step3: recursively call the left and right side of the array
 * 
 * time: O(n)
 * space: O(n)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        
        int mid = left + (right - left) / 2;
        //everytime we find the mid, we create a new node
        TreeNode root = new TreeNode(nums[mid]);
        //recursively call the left and right side of the array
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

}
// @lc code=end

