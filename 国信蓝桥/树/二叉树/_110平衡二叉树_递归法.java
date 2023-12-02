package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _110平衡二叉树_递归法 {
    /**
     *一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!= -1;
    }

    /**
     *
     * @param root
     * @return
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
