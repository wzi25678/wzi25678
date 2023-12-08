package 代码随想录.树.二叉树的遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class __515在每个树行中找最大值 {
    /**
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.val >= max){
                    max = node.val;
                }
                if (node.left!= null) queue.offerLast(node.left);
                if (node.right!= null) queue.offerLast(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
