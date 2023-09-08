package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.Queue;

public class __513找树左下角的值__从右往左出队 {
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


	/*
	用队列，层次排序，从右往左遍历，给每一个值都赋res，最终得到res的一定是最底层且最左边的
	 */
	public int findBottomLeftValue(TreeNode root) {
		int res = 0;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()){
			TreeNode curNode = queue.poll();
			if (curNode.right != null){
				queue.offer(curNode.right);
			}
			if (curNode.left != null){
				queue.offer(curNode.left);
			}
			res = curNode.val;
		}
		return res;
	}
}
