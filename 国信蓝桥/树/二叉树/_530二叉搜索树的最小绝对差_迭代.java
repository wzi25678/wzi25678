package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _530二叉搜索树的最小绝对差_迭代 {
    TreeNode prevNode;  //定义在这里，会有一个默认的空参构造器

    /**
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();

        TreeNode curNode = root;
        int result = Integer.MAX_VALUE;
        while (curNode != null || !myStack.isEmpty()) {
            if (curNode != null){
                myStack.push(curNode);
                curNode = curNode.left;
            }else {
                curNode = myStack.pop();
                if (prevNode != null){
                    result = Math.min(result,Math.abs(curNode.val - prevNode.val));
                }
                prevNode = curNode;
                curNode = curNode.right;
            }
        }
        return result;
    }
}
