package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


public class _112路径总和_迭代 {
    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        //myStack1存储添加的node
        Deque<TreeNode> myStack1 = new ArrayDeque<TreeNode>();
        //myStack2存储当前节点的路径总和
        Deque<Integer> myStack2 = new ArrayDeque<Integer>();
        myStack1.push(root);
        myStack2.push(root.val);
        while (!myStack1.isEmpty()){
            int myStack1Size = myStack1.size();
            for (int i = 0; i < myStack1Size;i++){
                TreeNode node = myStack1.pop();
                int sum = myStack2.pop();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if (node.left == null && node.right == null && sum == targetSum){
                    return true;
                }
                // 右节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.right!= null){
                    myStack1.push(node.right);
                    myStack2.push(sum + node.right.val);
                }
                // 左节点，压进去一个节点的时候，将该节点的路径数值也记录下来
                if (node.left!= null){
                    myStack1.push(node.left);
                    myStack2.push(sum + node.left.val);
                }
                // 如果当前节点的路径数值等于sum，那么就返回true
            }
        }
        return false;
    }
}
