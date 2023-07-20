package 西湖算法题解___中等题.二叉树的迭代实现;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 中序迭代 {
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

	public List<Integer> inOrderTraversalIterative(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if (root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while ( !stack.isEmpty() || node != null){
			if (node != null){
				stack.push(node);
				node = node.left;
			}else{
				node = stack.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}
}
