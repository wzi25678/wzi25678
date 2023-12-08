package 代码随想录.树.一般数_森林;

import 代码随想录.树.TreeNode;

public class _572另一棵树的子树_dfs暴力匹配 {
    /**
     *  就是说，从root上的某个节点开始，如果等于了subroot，
     *  能否遍历出subroot的所有节点
     *
     *  root 树上的节点数量范围是 [1, 2000]
     *  subRoot 树上的节点数量范围是 [1, 1000]
     *
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfsMatch(root,subRoot);
    }

    /**
     *
     * @param root
     * @param subRoot
     * @return
     */
    private boolean dfsMatch(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        return checkCompare(root,subRoot) || dfsMatch(root.left , subRoot) || dfsMatch(root.right,subRoot);
    }

    /**
     *
     * @param root
     * @param subRoot
     * @return
     */
    private boolean checkCompare(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }
        return checkCompare(root.left,subRoot.left) && checkCompare(root.right,subRoot.right);
    }
}
