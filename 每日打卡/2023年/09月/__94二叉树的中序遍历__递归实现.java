package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __94二叉树的中序遍历__递归实现 {
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

	List<Integer> res = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if ( root != null){
			inorderTraversal(root.left);
			res.add(root.val);
			inorderTraversal(root.right);
		}
		return res;
	}
}
