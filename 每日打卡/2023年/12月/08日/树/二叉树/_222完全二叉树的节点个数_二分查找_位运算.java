package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _222完全二叉树的节点个数_二分查找_位运算 {
    /**
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        // TODO 根据完全二叉树的性质，每次都去找当前节点的右节点，去进行二分查找操作
        if (root == null) {
            return 0;
        }
        int levelSize = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node.left != null) {
            levelSize++;
            node = node.left;
        }
        int low = 1<<levelSize,high = (1<<(levelSize+1))-1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (myExists(root,levelSize, mid)) {
                low = mid ;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     *
     * @param root
     * @param levelSize
     * @param k
     * @return
     */
    private boolean myExists(TreeNode root, int levelSize, int k) {
        int bits = 1<<(levelSize-1);
        TreeNode node = root;
        while (node!= null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            }else{
                node = node.right;
            }
            bits >>= 1;
        }
        return node!= null;
    }
}
