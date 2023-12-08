package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _222完全二叉树的节点个数 {
    /**
     *
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        result++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left!= null) {
                    queue.offer(node.left);
                    result++;
                }
                if (node.right!= null) {
                    queue.offer(node.right);
                    result++;
                }
                size--;
            }
        }
        return result;
    }
}
