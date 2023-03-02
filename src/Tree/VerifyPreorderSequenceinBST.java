package Tree;

import java.util.Stack;

//只要我有左子树，就一直放进stack里，直到遇到右子树的节点 > 栈顶，就一直弹出，保证所有左子树退出（比root小的数都是右子树）
public class VerifyPreorderSequenceinBST {
    public static boolean verifyPreorder (int[] array){
        //maintain a stack to compare number
        Stack<Integer> stack = new Stack<>(); //space O(n)
        int min = Integer.MIN_VALUE;
        //traverse every element
        for (int x : array){
            if (x < min){ //violate the bst
                return  false;
            }
            //if the leftSubtree(smaller number)in the stack, need to pop out, and need to record which of the left sub-node
            while (!stack.isEmpty() && x > stack.peek()){
                min = stack.pop();
            }
            stack.push(x);
        }
        return true;
    }

    //O(n)
    //O(n)

    public static void main(String[] args) {
        System.out.println(verifyPreorder(new int[]{5,2,1,3,6}));
    }
}
