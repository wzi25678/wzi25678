package 代码随想录.树.二叉树的遍历.迭代遍历;


import 代码随想录.树.二叉树的遍历.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 前序遍历 { //迭代下，前序中序都使用栈来实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        while (!myStack.isEmpty() || node!= null) { //根左右
            while (node!= null) {   //一直向左找
                res.add(node.val);
                myStack.push(node);
                node = node.left;
            }
            node = myStack.pop();   //左不了了，就吃来，向右找
            node = node.right;
        }
        return res;
    }
}
