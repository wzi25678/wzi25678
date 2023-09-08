package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __113路径总和II__输出路径上的所有元素 {
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


	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> everyTry = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		/**解题思路：
		 *  和之前一样，dfs
		 *  然后用一个List去记录每次走的路径，
		 *  最后用给一个List.remove删除掉走过的痕迹
		 *
		 */
		dfs(root,0,targetSum);
		return res;
	}

	/**
	 *
	 * @param root
	 * @param num
	 * @param targetSum
	 */
	private void dfs(TreeNode root, int num, int targetSum) {
		if (root == null){
			return;
		}
		num += root.val;
		everyTry.add(root.val);
		if (num == targetSum && root.left == null && root.right == null){   //满足这个条件，说明走到底了
			res.add(new ArrayList<>(everyTry));
		}
		dfs(root.left,num,targetSum);
		dfs(root.right,num,targetSum);
		//确保能走到底
		everyTry.remove(everyTry.size()-1);
	}
}
