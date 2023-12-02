package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _98验证二叉搜索树_简介递归 {
    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return ValidBST(Long.MIN_VALUE,Long.MAX_VALUE,root);
    }

    /**
     *
     * @param minValue
     * @param maxValue
     * @param root
     * @return
     */
    private boolean ValidBST(long minValue, long maxValue, TreeNode root) {
       if (root == null) {
           return true;
       }
       if (root.val <= minValue || root.val >= maxValue) {
           return false;
       }
       return ValidBST(minValue,root.val, root.left) && ValidBST(root.val,maxValue,root.right);
    }
}
