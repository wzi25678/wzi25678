package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111二叉树的最小深度_bfs {
    /**
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!= null) {
                    queue.offer(node.left);
                }
                if (node.right!= null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
