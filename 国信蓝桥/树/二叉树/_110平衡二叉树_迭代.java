package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _110平衡二叉树_迭代 {
    /**
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> myStack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (!myStack.isEmpty() || root!= null) {
            while (root!= null) {
                myStack.push(root);
                root = root.left;
            }
            TreeNode node = myStack.peek();
            // 右结点为null或已经遍历过
            if (node.right == null || node.right == prev) {
                if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
                    return false;
                }
                myStack.pop();
                prev = node;
                root = null;// 当前结点下，没有要遍历的结点了
            }else {
                root = node.right;
            }
        }
        return true;
    }

    /**
     * 层序遍历，求结点的高度
     *
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left!= null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right!= null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return height;
    }
}
