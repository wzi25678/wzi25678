package 西湖算法题解___中等题.二叉树的迭代实现;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 后序迭代 {

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

	public List<Integer> postOrderTraversalIterative(TreeNode root){
		List<Integer> result = new LinkedList<>();
		if (root == null){
			return result;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode node = stack.pop();
			result.add(0, node.val);
			if (node.left != null){
				stack.push(node.left);
			}
			if (node.right != null){
				stack.push(node.right);
			}
		}
		return result;
	}

}
