package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _669修剪二叉搜索树_递归 {
    /**
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // TODO 删除不满足在[low,high]这个区间内的其他节点，同时要调整好整颗二叉树
        if (root == null){
            return null;
        }
        if (root.val < low) {       //跳过当前值
            return trimBST(root.right,low ,high);
        }
        if (root.val > high){       //跳过当前值
            return trimBST(root.left,low,high);
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low ,high);
        return root;
    }
}
