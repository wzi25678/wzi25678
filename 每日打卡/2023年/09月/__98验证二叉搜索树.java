package 西湖算法题解___中等题;

public class __98验证二叉搜索树 {

	public static void main(String[] args) {

	}

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

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}

	/**
	 *
	 * @param node
	 * @param lower
	 * @param upper
	 * @return
	 */
	private boolean isValidBST(TreeNode node, long lower, long upper) {
		if (node == null){
			return true;
		}
		//一定每个值要卡在中间才行
		if (node.val <= lower || node.val >= upper){
			return false;
		}
		//保证按照规则来，往左边走就要，不能比当前值还大了；往右边走就要，不能比当前值还小了；
		return isValidBST(node.left,lower, node.val) && isValidBST(node.right, node.val,upper);
	}


}
