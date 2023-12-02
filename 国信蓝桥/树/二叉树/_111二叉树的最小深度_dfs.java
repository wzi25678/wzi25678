package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

public class _111二叉树的最小深度_dfs {
    //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

    public int minDepth(TreeNode root) {
        //这道题就是要求最小的叶子结点到根节点的数量
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left!= null){
            min_depth = Math.min(min_depth,minDepth(root.left));
        }
         if (root.right!= null){
            min_depth = Math.min(min_depth,minDepth(root.right));
        }
         return min_depth + 1;
    }
}
