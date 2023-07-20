package 西湖算法题解___中等题.二叉树的递归遍历;

import 西湖算法题解___中等题.二叉树的迭代实现.前序迭代;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
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
		inOrderHelp(root,result);
		return result;
	}

	/**
	 *
	 * @param node
	 * @param result
	 */
	private void inOrderHelp(TreeNode node, List<Integer> result) {
		if (node == null){
			return;
		}
		inOrderHelp(node.left, result);
		result.add(node.val);
		inOrderHelp(node.right, result);
	}


}
