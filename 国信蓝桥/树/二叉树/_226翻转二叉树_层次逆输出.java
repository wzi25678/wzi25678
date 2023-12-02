package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _226翻转二叉树_层次逆输出 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> myQueue = new ArrayDeque<TreeNode>();
        myQueue.offerLast(root);
        while (!myQueue.isEmpty()) {
            //每一层全部获取后，反转当前节点的所有节点
            //本题是TreeNode类型，所以得自己调整好，返回的话，就是返回root首节点
            /*
            从图中，可以看出，我只要对每个节点，调换它的左右节点的位置，那么必然最后的所有节点都会逆转所有左右节点的位置
             */
            TreeNode node = myQueue.pollFirst();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left!= null) {
                myQueue.offerLast(node.left);
            }
            if (node.right!= null) {
                myQueue.offerLast(node.right);
            }
        }
        return root;
    }
}
