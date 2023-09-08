package 西湖算法题解___中等题;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class __199二叉树的右视图__02 {

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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if(root == null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int levelSize = queue.size();

			for (int i=0;i<levelSize;i++){
				TreeNode node = queue.poll();
				if (i==levelSize-1){
					res.add(node.val);
				}
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
		}
		return res;
	}
}
