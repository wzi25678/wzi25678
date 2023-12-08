package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _701二叉搜索树中的插入操作 {
    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // TODO 二叉搜索树实现插入功能
        /*
        1.找到对应插入位置，必须是插在叶子结点上，，，
        2.进行二叉平衡树的调整，
         */
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode newRoot = root;
        TreeNode prevRoot = root;
        while (root != null){
           prevRoot = root;
           if (root.val > val) {
               root = root.left;
           } else if (root.val < val) {
               root = root.right;
           }
        }
        if (prevRoot.val > val){
            prevRoot.left = new TreeNode(val);
        }else {
            prevRoot.right = new TreeNode(val);
        }
        return newRoot;
    }
}
