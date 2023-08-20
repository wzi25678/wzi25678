package 西湖算法题解___中等题.二叉树的递归遍历;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
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
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> result  =  new ArrayList<>();
		preOrder(root,result);
		return result;
	}

	/**
	 *
	 * @param node
	 * @param result
	 */
	private void preOrder(TreeNode node, List<Integer> result) {
		if (node == null){
			return;
		}
		result.add(node.val);
		preOrder(node.left,result);
		preOrder(node.right,result);
	}
}
