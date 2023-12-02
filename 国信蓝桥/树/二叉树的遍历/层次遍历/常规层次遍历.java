package 代码随想录.树.二叉树的遍历.层次遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 常规层次遍历 {       //广度搜索遍历
    public List<List<Integer>> levelOrder(TreeNode root) {  // 队列实现
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Deque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = myQueue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = myQueue.remove();
                level.add(node.val);
                if (node.left!= null) myQueue.add(node.left);
                if (node.right!= null) myQueue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
