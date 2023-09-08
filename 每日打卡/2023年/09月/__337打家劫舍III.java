package 西湖算法题解___中等题;

public class __337打家劫舍III {
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

	public int rob(TreeNode root) {
		/**
		解题思路：
		    需要有间隔的选择二叉树的结点   ->    dp???

		那么怎么dp呢？肯定有个状态，有个累加和
		  ->暴力算每个节点选择了，和没被选择的情况
		 */

		int res []  = trackBack(root);
		return Math.max(res[0], res[1]);
	}

	/**
	 *
	 * @param root
	 * @return
	 */
	private int[] trackBack(TreeNode root) {
		if (root == null){
			return new int[]{0,0};
		}
		int [] left = trackBack(root.left);
		int [] right = trackBack(root.right);
		int valueNo = left[0] + right[0];   //只要父节点没偷，他就可以左右孩子结点都偷
		int valueYes = left[1] + right[1] + root.val;
		valueYes = Math.max(valueYes,valueNo);
		return new int[]{valueYes,valueNo};
	}
}
