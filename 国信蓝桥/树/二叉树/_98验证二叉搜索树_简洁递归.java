package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _98验证二叉搜索树_简洁递归 {
//    TreeNode maxNode ;     // = new TreeNode(Long.MIN_VALUE);
//    TreeNode minNode ;      // = new TreeNode(Long.)
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
     * @param minNodeValue
     * @param maxNodeValue
     * @param root
     * @return
     */
    private boolean ValidBST(long minNodeValue,long maxNodeValue ,TreeNode root) {
        if(root == null){
            return true;
        }
        if (root.val <= minNodeValue || root.val >= maxNodeValue){
            return false;
        }
        return ValidBST(minNodeValue,root.val,root.left) && ValidBST(root.val,maxNodeValue,root.right);
    }
}
