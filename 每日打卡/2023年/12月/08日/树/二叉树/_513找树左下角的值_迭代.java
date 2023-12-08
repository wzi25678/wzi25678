package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _513找树左下角的值_迭代 {
    /**
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        myQueue.offer(root);
        int res = 0;
        while (!myQueue.isEmpty()) {
            int levelSize = myQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = myQueue.poll();
                if (i == 0){
                    res = node.val;
                }
                if (node.left!= null) {
                    myQueue.offer(node.left);
                }
                if (node.right!= null) {
                    myQueue.offer(node.right);
                }
//                if (i == levelSize - 1) {
//                    res = node.val;
//                }
            }
        }
        return res;
    }
}
