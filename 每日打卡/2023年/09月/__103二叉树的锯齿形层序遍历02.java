package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class __103二叉树的锯齿形层序遍历02 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 */
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null){
			return res;
		}
		Queue<TreeNode> queue_adq = new ArrayDeque<>();
		queue_adq.add(root);
		boolean flag = false;//记录顺序
		while (!queue_adq.isEmpty()){
			List<Integer> arrayList =  new ArrayList<>();
			int levelsize = queue_adq.size();
			for (int i=0;i<levelsize;i++){
				TreeNode node = queue_adq.poll();
				if (node.left != null){
					queue_adq.offer(node.left);
				}
				if (node.right != null){
					queue_adq.offer(node.right);
				}
				if (flag){
					arrayList.add(0,node.val);  //每次将获取的值，加到最前面
				}else {
					arrayList.add(node.val);
				}
			}
			flag=!flag;
			res.add(arrayList);
		}
		return res;
	}


}
