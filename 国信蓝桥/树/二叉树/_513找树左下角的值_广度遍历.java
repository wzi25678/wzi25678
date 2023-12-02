package 代码随想录.树.二叉树;

import 代码随想录.树.TreeNode;

import java.util.*;

public class _513找树左下角的值_广度遍历 {
    /**
     * 层次遍历，最后一排的第一个元素
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
       int result = 0;
       Queue<TreeNode> myQueue = new ArrayDeque<TreeNode>();
       myQueue.offer(root);
       while (!myQueue.isEmpty()){
           TreeNode node = myQueue.poll();
           if (node.right!= null){
               myQueue.offer(node.right);
           }
           if (node.left!= null){
               myQueue.offer(node.left);
           }
           result = node.val;
       }
       return result;
    }
}
