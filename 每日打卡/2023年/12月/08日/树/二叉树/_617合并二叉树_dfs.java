package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _617合并二叉树_dfs {
    /**
     * 二叉树的重叠覆盖，即相同部分，就数字合并，不同部分，则形成合并后的子树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left , root2.left);
        mergeNode.right = mergeTrees(root1.right,root2.right);
        return mergeNode;
    }
}
