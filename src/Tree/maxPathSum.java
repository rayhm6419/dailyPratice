package Tree;

import javax.swing.tree.TreeNode;

public class maxPathSum {
    /**
     1. the node only can use once
     2. the path does not need to pass through the root

     if the node contains negative value, just forget it
     does not need to be leaf node

     this is a inorder traverse, traverse the node from bottom to top, record and update the maxPathSum in mean while


     base case: if the current node is a null, return
     sup-problem: find each path can be the largest path sum
     remember to update the max

     Last return of the the path, including the node itself
     */

    public int maxPathSum(treeNode root) {
        //coner case, if this is null, no maxPathSum
        if (root == null){
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    private int helper(treeNode root, int[] max){
        //base case
        if (root == null){
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        if (left <= 0){
            return 0;
        }

        if (right <= 0){
            return 0;
        }

        //人字形组合
        max[0] = Math.max(left + right + root.val, max[0]);
        //最后返回是一条直上直下的
        return Math.max(left, right) + root.val;
    }
}
