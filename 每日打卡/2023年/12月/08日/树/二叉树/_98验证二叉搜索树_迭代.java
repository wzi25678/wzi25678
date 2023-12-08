package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _98验证二叉搜索树_迭代 {
    public boolean isValidBST(TreeNode root){
        if (root == null){
            return true;
        }
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        TreeNode prevNode = null;
        while(root != null || !myStack.isEmpty()){
            while (root != null){
                myStack.push(root);
                root = root.left;   //左
            }
            // 中，处理
            TreeNode currNode = myStack.pop();
            if (prevNode != null && prevNode.val >= currNode.val){
                return false;
            }
            prevNode = currNode;
            root = currNode.right;  //右
        }
        return true;
    }
}
