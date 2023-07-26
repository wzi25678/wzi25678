package 西湖算法题解___简单题;

import java.util.ArrayDeque;
import java.util.Queue;

public class __437路径总和III__方法二 {
	public static void main(String[] args) {

	}

	  public static class TreeNode {
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

	  /**
		   *
		   * 二叉树的节点个数的范围是 [0,1000]
		   * -109 <= Node.val <= 109
		   * -1000 <= targetSum <= 1000
		   *
		   * @param root
		   * @param targetSum
		   * @return
	   */

	  int targetSum,count= 0;

	  public int pathSum(TreeNode root, int targetSum){
			/*
			没啥技巧，就是一个BFS，然后用一个res记录每次累加的结果，用一个count记录出现你要的结果的出现次数
			 */
		  if (root == null) {
			  return 0;
		  }
		  this.targetSum = targetSum;
		  Queue<TreeNode> queue = new ArrayDeque<>();
		  queue.add(root);
		  while (queue.isEmpty()){
			  TreeNode node = queue.remove();
			  BFStoSum(node,0);
			  if (node.left != null){
				  queue.add(node.left);
			  }
			  if (node.right != null){
				  queue.add(node.right);
			  }
		  }
		  return count;
	  }

		  private void BFStoSum(TreeNode root, long Sum) {
			if (root == null){
				return ;
			}
			int val = root.val;

			Sum += val;
			if (Sum == targetSum){
				count++;
			}
			//等于也得继续调它的左右节点进行累加
			BFStoSum(root.left,Sum);
			BFStoSum(root.right,Sum);
		  }
	  }
}
