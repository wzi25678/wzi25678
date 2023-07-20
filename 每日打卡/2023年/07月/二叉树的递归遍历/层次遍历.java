package 西湖算法题解___中等题.二叉树的递归遍历;

import java.util.ArrayList;
import java.util.List;

public class 层次遍历 {

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
	public List<List<Integer>> levelOrderTraversalIterative(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		levelOrderHelper(root,0,result);
		return result;

	}

	/**
	 *
	 * @param node
	 * @param level
	 * @param result
	 */
	private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null){
			return;
		}

		if (level >= result.size()){
			result.add(new ArrayList<>());
		}

		result.get(level).add(node.val);

		levelOrderHelper(node.left,level+1,result);
		levelOrderHelper(node.right,level+1,result);
	}
}
