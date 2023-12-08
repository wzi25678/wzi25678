package 代码随想录.树.二叉树的遍历.层次遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class __107二叉树的层序遍历II_更好的利用Deque的性质 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
        //还从左到右，但是这回是从底部到顶部
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        if (root == null) return res;
        myQueue.offerLast(root);
        while (!myQueue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = myQueue.size();
            for (int i = 1; i <= currentLevelSize; i++){
                TreeNode node = myQueue.peekFirst();
                level.add(myQueue.pollFirst().val);
//                TreeNode node = myQueue.pollFirst();
//                level.add(node.val);
                if (node.left!= null) myQueue.offerLast(node.left);
                if (node.right!= null) myQueue.offerLast(node.right);
            }
            res.add(level);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i-- ) {
            result.add(res.get(i));
        }
        return result;
    }
}
