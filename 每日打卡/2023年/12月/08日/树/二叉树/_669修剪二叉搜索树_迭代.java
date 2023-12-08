package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _669修剪二叉搜索树_迭代 {
    /**
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root == null){
            return null;
        }
        while (root != null && (root.val < low || root.val > high)){
            if (root.val < low){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        TreeNode curNode = root;
        while (curNode != null){
            while (curNode.left != null && curNode.left.val < low){
                curNode.left = curNode.left.right;
            }
            curNode = curNode.left;
        }
        curNode = root;
        while (curNode != null){
            while (curNode.right != null && curNode.right.val > high){
                curNode.right = curNode.right.left;
            }
            curNode = curNode.right;
        }
        return root;
    }
}
