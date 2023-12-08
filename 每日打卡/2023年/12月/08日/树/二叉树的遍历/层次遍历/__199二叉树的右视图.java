package 代码随想录.树.二叉树的遍历.层次遍历;

import 代码随想录.树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class __199二叉树的右视图{
    /**
     * 返回每一层最后一个元素，即为每一层最右边的元素
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new ArrayList<Integer>();
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
       while (!queue.isEmpty()) {
           int levelSize  = queue.size();
           for (int i = 0; i < levelSize; i++) {
               TreeNode node = queue.pollFirst();
               if (node.left!= null) queue.offerLast(node.left);
               if (node.right!= null) queue.offerLast(node.right);
               if (i == levelSize - 1) {
                   result.add(node.val);
                   break;   //都可以，毕竟最后一个元素
               }
           }
       }
        return result;
    }
}
