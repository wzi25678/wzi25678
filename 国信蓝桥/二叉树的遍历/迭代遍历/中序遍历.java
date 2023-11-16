package 代码随想录.树.二叉树的遍历.迭代遍历;

import 代码随想录.树.二叉树的遍历.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        while (!myStack.isEmpty() || node!= null) {
            while (node!= null) {
                myStack.push(node);
                node = node.left;
            }   //先左到底，再res加入当前node值
            node = myStack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
