package 代码随想录.树.二叉树的遍历.递归遍历;

import 代码随想录.树.二叉树的遍历.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;

    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
