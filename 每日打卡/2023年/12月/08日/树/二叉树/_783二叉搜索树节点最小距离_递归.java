package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _783二叉搜索树节点最小距离_递归 {
    TreeNode prev;  //记录上一个遍历的节点
    int result = Integer.MAX_VALUE;
    /**
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        if (root.left == null && root.right == null){
            return root.val;
        }
        traversal(root);
        return result;
    }

    /**
     *
     * @param root
     */
    private void traversal(TreeNode root) {
        if (root == null){
            return;
        }
        //左
        traversal(root.left);
        //中
        if (prev != null){
            result = Math.min(result,root.val - prev.val);
        }
        prev = root;
        //右
        traversal(root.right);
    }
}
