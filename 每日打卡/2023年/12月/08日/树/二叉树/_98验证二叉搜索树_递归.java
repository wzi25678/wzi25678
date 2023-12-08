package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _98验证二叉搜索树_递归 {
    TreeNode maxNode ;      //      = new TreeNode(Integer.MIN_VALUE)
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
        boolean leftNode = isValidBST(root.left);
        if (!leftNode){
            return false;
        }
        //中
        if (maxNode != null && root.val <= maxNode.val){
            return false;
        }
        maxNode = root;
        //右
        boolean rightNode = isValidBST(root.right);
        return rightNode;
    }
}
