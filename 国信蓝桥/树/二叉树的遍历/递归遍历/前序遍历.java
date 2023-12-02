package 代码随想录.树.二叉树的遍历.递归遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class 前序遍历 {
    public void preorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
}
