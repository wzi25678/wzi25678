package 西湖算法题解___简单题;

import java.util.ArrayDeque;
import java.util.Queue;

public class __226翻转二叉树__层次序列方式反转 {
	public static void main(String[] args) {

	}
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

	public TreeNode invertTree(TreeNode root) {
		if (root == null){
			return null;
		}

		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			//把下一层的结点尝试加入进来
			TreeNode node = queue.poll(); //开始从左往右取出当前层的结点
			//就直接让当前结点的left/right进行交换
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null){
				queue.offer(node.left);
			}
			if (node.right != null){
				queue.offer(node.right);
			}
		}
		return root;
	}

}
