package 代码随想录.树.一般数_森林;

import 代码随想录.树.TreeNode;

public class _101对称二叉树_递归 {
    /**
     *  如果以中心为轴线，这道题的本质，其实是，左边部分->    和   右边部分 <-    两边同时朝内，判断是否相等
     *  即，每次去比较左右节点的外围
     *  即   root.left.left == root.right.right
     *      root.left.right == root.right.left
     *
     * @param root
     * @return
     */
    public  boolean isSymmetric(TreeNode root) {
        if (root == null || root.left == null ||    root.right == null){
            return false;
        }
        return comparePeriphery(root.left,root.right);

    }

    /**
     *
     *
     * @param leftNode
     * @param rightNode
     * @return
     */
    private boolean comparePeriphery(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode!= null){
            return false;
        }
        if (leftNode!=null && rightNode == null){
            return false;
        }
        if (leftNode == null && rightNode == null){
            return true;
        }
        //传入的leftNode，与rightNode就是需要比较的对象
        if (leftNode.val != rightNode.val){      //一个相等，不一定最终返回true啊
            return false;
        }
        return comparePeriphery(leftNode.left,rightNode.right) && comparePeriphery(leftNode.right,rightNode.left);
    }
}
