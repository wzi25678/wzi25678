package 西湖算法题解___中等题.二叉树的递归遍历;

import java.util.ArrayList;
import java.util.List;

public class 后序遍历 {

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

	/**
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> postOrderTraversalIterative(TreeNode root){
		List<Integer> result = new ArrayList<>();
		postOrderHelper(root,result);
		return  result;
	}

	/**
	 *
	 * @param node
	 * @param result
	 */
	private void postOrderHelper(TreeNode node, List<Integer> result) {
		if (node == null){
			return;
		}
		postOrderHelper(node.left,result);
		postOrderHelper(node.right,result);
		result.add(node.val);
	}


}
