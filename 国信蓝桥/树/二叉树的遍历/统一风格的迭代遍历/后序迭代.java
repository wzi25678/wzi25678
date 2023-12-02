package 代码随想录.树.二叉树的遍历.统一风格的迭代遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 后序迭代 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        if (root!= null) {
            myStack.push(root);
        }
        while (!myStack.isEmpty()) {
            TreeNode node = myStack.peek();
            if (node!= null) {
                myStack.pop();
                myStack.push(node);
                myStack.push(null);
                if (node.right!= null) {
                    myStack.push(node.right);
                }
                if (node.left!= null) {
                    myStack.push(node.left);
                }
            } else {
                myStack.pop();
                node = myStack.peek();
                myStack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
