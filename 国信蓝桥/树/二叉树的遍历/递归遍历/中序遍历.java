package 代码随想录.树.二叉树的遍历.递归遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        inorder(root,result);
        return result;
    }

    /**
     * 中序遍历
     * @param root
     * @param result
     */
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
