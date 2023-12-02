package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _235二叉搜索树的最近公共祖先_递归 {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        // 后序遍历
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        //从下往上找，先到最底层
        if (leftNode == null && rightNode == null){
            return null;
        } else if (leftNode != null && rightNode == null) {
            return leftNode;
        } else if (rightNode != null && leftNode == null) {
            return rightNode;
        }else { // rightNode != null 并且 leftNode != null
            return root;
        }
    }
}
