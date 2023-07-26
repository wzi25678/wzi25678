package 西湖算法题解___简单题;

import java.util.Stack;

public class __226翻转二叉树__深度遍历反转 {
	public static void main(String[] args) {

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = stack.pop();
				TreeNode temp = cur.left;
				cur.left = cur.right;
				cur.right = temp;
				if (cur.left != null) {
					stack.push(cur.left);
				}
				if (cur.right != null) {
					stack.push(cur.right);
				}
			}
		}
		return root;

	}
}
