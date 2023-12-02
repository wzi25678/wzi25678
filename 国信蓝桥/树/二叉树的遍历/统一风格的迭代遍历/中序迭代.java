package 代码随想录.树.二叉树的遍历.统一风格的迭代遍历;

import 代码随想录.树.TreeNode;

import java.util.*;

public class 中序迭代 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
//        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        if (root == null) return res;
        while (!myStack.isEmpty()){
            TreeNode node = myStack.peek();
            if (node == null){
                myStack.pop();
                if (node.right != null){
                    myStack.push(node.right);
                }
                myStack.push(node);
                myStack.push(null);
                if (node.left != null){
                    myStack.push(node.left);
                }
            }else {
                myStack.pop();
                node = myStack.peek();
                myStack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

}
