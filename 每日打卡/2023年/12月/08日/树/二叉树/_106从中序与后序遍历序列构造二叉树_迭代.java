package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _106从中序与后序遍历序列构造二叉树_迭代 {
    /**
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> myStack = new LinkedList<TreeNode>();
        myStack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i>=0;i--){
            int postOrderVal = postorder[i];
            TreeNode node = myStack.peek();
            if (node.val != inorder[inorderIndex]){
                node.right = new TreeNode(postOrderVal);
                myStack.push(node.right);
            }else {
                while (!myStack.isEmpty() && myStack.peek().val == inorder[inorderIndex]){
                    node = myStack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postOrderVal);
                myStack.push(node.left);
            }
        }
        return root;
    }

}
