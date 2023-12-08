package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _701二叉搜索树中的插入操作_递归 {
    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }else if(root.val > val) {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
