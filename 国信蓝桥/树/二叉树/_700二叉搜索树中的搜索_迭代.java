package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _700二叉搜索树中的搜索_迭代 {
    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (val == root.val){
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
