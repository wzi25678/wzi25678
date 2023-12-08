package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _513找树左下角的值_dfs {
    /**
     *
     * @param root
     * @return
     */
    int  curValue = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs_findBottomLeftValue(root,0);
        return curValue;
    }

    private void dfs_findBottomLeftValue(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs_findBottomLeftValue(root.left,height);
        dfs_findBottomLeftValue(root.right,height);
        if (height > curHeight) {
            curHeight = height;
            curValue = root.val;
        }
    }
}
