package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _98验证二叉搜索树_中序遍历 {
    private long prev = Long.MIN_VALUE;
    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (root.val <= prev){
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}
