package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _513找树左下角的值_递归 {
    private int deepth = -1;
    private int value = 0;
    /**
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root){
        value = root.val;
        findLeftestValue(root,0);
        return value;
    }

    /**
     *
     * @param root
     * @param curDepth
     */
    private void findLeftestValue(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (curDepth >deepth){
                value = root.val;
                deepth = curDepth;
            }
        }
        if (root.left!= null) {
            findLeftestValue(root.left,curDepth+1); //递归左子树
        }
        if (root.right != null) {
            findLeftestValue(root.right,curDepth+1); //递归右子树
        }
    }
}
