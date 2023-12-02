package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _104二叉树的最大深度_bfs {
    /**
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int result = 0;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                if(node.left!= null){
                    queue.offerLast(node.left);
                }
                if(node.right!= null){
                    queue.offerLast(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
