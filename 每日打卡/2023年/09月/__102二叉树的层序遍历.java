package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class __102二叉树的层序遍历 {
	public static void main(String[] args) {

	}
		//队列


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

	public List<List<Integer>> levelOrder(TreeNode root) {
		/*
		二叉树如何实现层次排序？
		-> 队列

		那每次进多少个对呢？
		第一次肯定进头咯，头进去了，就去判断下一层，，，对当前加入队列的所有结点去顺序判断左右结点是否有，有则加入队列
		那么队列的长度大小就一直在变化，那么就得每次加入值、判断值之前先记录好队列的当前长度
		 */

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null){
			return res;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()){
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();

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
			res.add(levelNodes);
		}
		return res;
	}


}
