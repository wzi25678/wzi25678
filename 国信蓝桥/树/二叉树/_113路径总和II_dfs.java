package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.*;

public class _113路径总和II_dfs {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    /**
     *给你二叉树的根节点 root 和一个整数目标和 targetSum ，
     * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     *
     * //   返回所有满足条件的路径
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    /**
     *
     * @param root
     * @param targetSum
     */
    private void dfs(TreeNode root, int targetSum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }
}
