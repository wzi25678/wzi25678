package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _617合并二叉树_bfs {
    /**
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        Deque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        Deque<TreeNode> myQueue1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> myQueue2 = new ArrayDeque<TreeNode>();
        myQueue.offerLast(mergeNode);
        myQueue1.offerLast(root1);
        myQueue2.offerLast(root2);
        while (!myQueue1.isEmpty() && !myQueue2.isEmpty()) {
            TreeNode node = myQueue.pollFirst(), node1 = myQueue1.pollFirst(), node2 = myQueue2.pollFirst();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    myQueue.offerLast(left);
                    myQueue1.offerLast(left1);
                    myQueue2.offerLast(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    myQueue.offerLast(right);
                    myQueue1.offerLast(right1);
                    myQueue2.offerLast(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }

        }
        return mergeNode;
    }
}
