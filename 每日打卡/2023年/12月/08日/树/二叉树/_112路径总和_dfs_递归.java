package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _112路径总和_dfs_递归 {
    /**
     * 寻找是否存在等于指定数值和的路径
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null){
            return targetSum == 0;
        }
        //开始dfs左右，去寻找
        if (root.left!= null && hasPathSum(root.left, targetSum)) {
            return true;
        }
        if (root.right!= null && hasPathSum(root.right, targetSum)) {
            return true;
        }
        return false;
    }

}
