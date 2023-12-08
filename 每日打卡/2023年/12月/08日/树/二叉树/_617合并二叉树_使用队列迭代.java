package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _617合并二叉树_使用队列迭代 {
    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        Deque<TreeNode> myQueue = new LinkedList<TreeNode>();
        myQueue.offerLast(root1);
        myQueue.offerLast(root2);
        while (!myQueue.isEmpty()) {
            TreeNode node1 = myQueue.pollFirst();
            TreeNode node2 = myQueue.pollFirst();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null){
                myQueue.offerLast(node1.left);
                myQueue.offerLast(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null){
                myQueue.offerLast(node1.right);
                myQueue.offerLast(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null){
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null){
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
