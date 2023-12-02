package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _530二叉搜索树的最小绝对差_递归 {
    private int result = Integer.MAX_VALUE;
    private TreeNode prevNode;
    /**
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        MinimumDifference(root);
        return result;
    }

    private void MinimumDifference(TreeNode root) {
        if (root == null){
            return;
        }
        MinimumDifference(root.left);
        if (prevNode != null){
            result = Math.min(result,Math.abs(root.val - prevNode.val));
        }
        prevNode = root;
        MinimumDifference(root.right);
    }

}
