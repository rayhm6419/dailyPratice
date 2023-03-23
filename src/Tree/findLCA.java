package Tree;

import javax.swing.tree.TreeNode;

public class findLCA {
    public treeNode lca(treeNode root, treeNode p, treeNode q){
        //base case
        if (root == null || root == p || root == q){
            return root;
        }
        treeNode left = lca(root.left, p, q);
        treeNode right = lca(root.right, p, q);

        if (left != null && right != null){
            return  root;
        }
        return left == null ? right : left;
    }
}
