package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _98验证二叉搜索树_递归02 {
    TreeNode maxNode;
    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        //左
        boolean leftNode = isValidBST(root.left);   //默认都是false，但还是给个显式初值
        if (leftNode != true){
            return false;
        }
        //中
        if (maxNode != null && root.val <= maxNode.val){
            return false;
        }
        maxNode = root;
        //右
        boolean right = isValidBST(root.right);
        return right;
    }
}
