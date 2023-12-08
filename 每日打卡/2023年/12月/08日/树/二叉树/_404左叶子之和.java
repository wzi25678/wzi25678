package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _404左叶子之和 {
    /**
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        //给定二叉树的根节点 root ，返回所有左叶子之和。
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right != null) {    //找出那种单纯只是左节点的
                ///                                                 而不是还有右节点的
                result += root.left.val;
            }else {
                result += sumOfLeftLeaves(root.left);   //对左节点递归
            }
        }
        if (root.right!= null) {
            result += sumOfLeftLeaves(root.right);  //对右节点递归
        }
        return result;
    }
}
