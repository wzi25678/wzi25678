package 代码随想录.树.一般数_森林;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _101对称二叉树_迭代法 {
    /**
     * 就你构造两个队列去入栈出栈去比较
     * 或者直接在双端队列的两侧去进行比较
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null){  //树中节点数目在范围 [1, 1000] 内
            return true;
        }
        Deque<TreeNode> myDeque = new LinkedList<TreeNode>();   //一般迭代就用LinkedList
        myDeque.offerFirst(root.left);  //左前右后
        myDeque.offerLast(root.right);
        while (!myDeque.isEmpty()){
            TreeNode leftNode = myDeque.pollFirst();
            TreeNode rightNode = myDeque.pollLast();
            if (leftNode == null && rightNode == null){
                continue;
            }
            if (leftNode == null || rightNode == null){
                return false;
            }
            if (leftNode.val!= rightNode.val){
                return false;
            }
            myDeque.offerFirst(leftNode.left);
            myDeque.offerLast(rightNode.right);
            myDeque.offerFirst(leftNode.right);
            myDeque.offerLast(rightNode.left);
        }
        return true;
    }
}
