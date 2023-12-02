package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _226翻转二叉树_dfs {
    /*
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Deque<TreeNode> myStack = new ArrayDeque<TreeNode>();
        myStack.push(root);
        while (!myStack.isEmpty()) {
            int levelSize = myStack.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = myStack.pop();
                TreeNode temp = curNode.left;
                curNode.left = curNode.right;
                curNode.right = temp;
                //出栈的时候，就先出右边，再出左边，实现调换顺序
                if (curNode.right!= null) {
                    myStack.push(curNode.right);
                }
                if (curNode.left!= null) {
                    myStack.push(curNode.left);
                }
            }
        }
        return root;
    }
}
