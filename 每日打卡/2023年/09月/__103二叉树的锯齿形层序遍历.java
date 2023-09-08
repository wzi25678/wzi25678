package 西湖算法题解___中等题;

import java.util.*;

public class __103二叉树的锯齿形层序遍历 {
	  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      if (root == null){
          return res;
      }

      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      int  derection = 1;
      while (!queue.isEmpty()){
          int levelSize = queue.size();
          List<Integer> levelNodes = new ArrayList<>();
          if (derection%2==1){
              for (int i=0;i<levelSize;i++){
                  TreeNode node = queue.poll();
                  levelNodes.add(node.val);

                  if (node.left != null){
                      queue.offer(node.left);
                  }
                  if (node.right != null){
                      queue.offer(node.right);
                  }
              }
          }else {
              for (int i=0;i<levelSize;i++){
                  TreeNode node = queue.poll();
                  levelNodes.add(node.val);
                  if (node.right != null){
                      queue.offer(node.right);
                  }
                  if (node.left != null){
                      queue.offer(node.left);
                  }
              }
              reverseQueue(queue);
          }
          derection++;
          res.add(levelNodes);
      }
      return res;
  }

    private void reverseQueue(Queue<TreeNode> queue) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            stack.push(queue.poll());
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
    }
}
