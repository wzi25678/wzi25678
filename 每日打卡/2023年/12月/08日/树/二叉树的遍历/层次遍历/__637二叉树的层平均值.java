package 代码随想录.树.二叉树的遍历.层次遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class __637二叉树的层平均值 {
    /**
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left!= null) queue.offerLast(node.left);
                if (node.right!= null) queue.offerLast(node.right);
            }
            result.add(sum / levelSize);
        }
        return result;
    }
}
