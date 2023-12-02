package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _235二叉搜索树的最近公共祖先_迭代 {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else{
                break;
            }
        }
        return root;
    }
}
