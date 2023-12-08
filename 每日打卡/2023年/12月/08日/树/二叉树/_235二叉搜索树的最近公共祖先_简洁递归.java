package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _235二叉搜索树的最近公共祖先_简洁递归 {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;    // 如果当前检测到p，q不在同一侧，那么必然当前root就是最近父节点
    }
}
