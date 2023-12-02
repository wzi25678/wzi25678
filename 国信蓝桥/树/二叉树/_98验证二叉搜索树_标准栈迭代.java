package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _98验证二叉搜索树_标准栈迭代 {
    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        //Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        TreeNode preNode = null;
        if (root != null) {
            //myStack.add(root);
            myStack.push(root);
        }
        while (!myStack.isEmpty()) {
            TreeNode curNode = myStack.peek();
            if (curNode != null) {
                myStack.pop();
                if (curNode.right != null) {
                    myStack.add(curNode.right);
                }
                myStack.add(curNode);
                myStack.add(null);
                if (curNode.left != null) {
                    myStack.add(curNode.left);
                }
            }else {
                myStack.pop();
                TreeNode tempNode = myStack.pop();
                if (preNode != null && preNode.val >= tempNode.val){
                    return false;
                }
                preNode = tempNode;
            }
        }
        return true;
    }
}
