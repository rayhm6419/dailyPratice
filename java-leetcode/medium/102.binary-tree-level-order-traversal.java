/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
      return res;
    }
    //need FIFO
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
      List<Integer> curList = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++){
         TreeNode cur = q.poll();
         curList.add(cur.key);
         if (cur.left != null){
        q.offer(cur.left);
      }
        if (cur.right != null){
        q.offer(cur.right);
      }
      }
      res.add(curList);
    }
    return res;
  }
}
// @lc code=end

