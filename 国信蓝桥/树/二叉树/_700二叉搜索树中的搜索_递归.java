package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _700二叉搜索树中的搜索_递归 {
    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // TODO 返回了这个点，就会自动递归返回它的子树
        if (root == null){
            return null;
        }
        if (val == root.val){
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
