package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.*;

public class _113路径总和II_bfs {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queueNode = new ArrayDeque<TreeNode>();
        Deque<Integer> queueSum = new ArrayDeque<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int sum = queueSum.poll() + node.val;
            if (node.left == null && node.right == null ) {
                if (sum == targetSum) {
                    getPath(node);
                }
            }else {
                if (node.left!= null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(sum);
                }
                if (node.right!= null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(sum);
                }
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        List<Integer> list = new ArrayList<Integer>();
        while (node!= null) {
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        res.add(list);
    }
}
