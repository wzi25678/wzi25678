package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _617合并二叉树_使用栈迭代 {
    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        myStack.push(root2);
        myStack.push(root1);
        while (!myStack.isEmpty()){
            TreeNode node1 = myStack.pop();
            TreeNode node2 = myStack.pop();
            node1.val += node2.val;
            if (node2.right != null && node1.right != null){
                myStack.push(node2.right);
                myStack.push(node1.right);
            }else {
                if (node1.right == null){
                    node1.right = node2.right;
                }
            }
            if (node2.left != null && node1.left != null){
                myStack.push(node2.left);
                myStack.push(node1.left);
            }else {
                if (node1.left == null){
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }
}
