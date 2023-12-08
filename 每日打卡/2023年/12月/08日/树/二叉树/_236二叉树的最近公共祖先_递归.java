package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _236二叉树的最近公共祖先_递归 {
    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TODO p,q为两个节点，然后要求这两个节点的最近父节点是哪个节点。
        //就是说，需要实现回溯遍历
        if(root == null || root == p || root == q){     // 递归结束条件
            return root;
        }
        // 后序遍历
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        
        //从下往上找，先到最底层
        if (leftNode == null && rightNode == null){
            return null;
        } else if (leftNode != null && rightNode == null) {
            return leftNode;
        } else if (rightNode != null && leftNode == null) {
            return rightNode;
        }else { // rightNode != null 并且 leftNode != null
            return root;
        }
    }
}
