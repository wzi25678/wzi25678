package 代码随想录.树.一般数_森林;

import 代码随想录.树.TreeNode;

public class _100相同的树_递归 {
    /**
     *给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //同时对p和q进行相同方法的遍历，判断它们是否每一次都会相同
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val!= q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
