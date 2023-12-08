package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _104二叉树的最大深度_dfs {
    /**
     * 想知道有多深
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //深度就是递归，同时用max去记录最大深度
        if (root == null){
            return   0;
        }else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
    }
}
