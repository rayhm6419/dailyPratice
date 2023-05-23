class Solution{
public int countUnivalSubtrees(TreeNode root) {
    if (root == null){
        return 0;
    }
    int[] count = new int[1];
    helper(root, count);
    return count[0];
}
private boolean helper(TreeNode root, int[] count){
    //base case return true, leaf node is also the node of subtree 
    if (root == null){
        return true;
    }
    boolean left = helper(root.left, count);
    boolean right = helper(root.right, count);

    if (left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)){
        count[0]++;
        return true;
    }
    return false;
}
}