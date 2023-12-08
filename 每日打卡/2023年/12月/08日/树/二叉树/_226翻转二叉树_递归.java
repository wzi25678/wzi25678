package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _226翻转二叉树_递归 {
    public TreeNode reverseTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = reverseTree(root.left);
        TreeNode right = reverseTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

