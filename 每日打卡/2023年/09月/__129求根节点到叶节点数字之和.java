package 西湖算法题解___中等题;

public class __129求根节点到叶节点数字之和 {
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

	public int sumNumbers(TreeNode root) {
		return dfs(root,0);
	}

	/**
	 *
	 * @param root
	 * @param res
	 * @return
	 */
	private int dfs(TreeNode root, int res) {
		if (root == null){
			return res;
		}

		int sum = res*10 +root.val;
		if (root.left == null && root.right == null){
			return sum;
		}else{
			return dfs(root.left,sum) + dfs(root.right,sum);
		}
	}
}
