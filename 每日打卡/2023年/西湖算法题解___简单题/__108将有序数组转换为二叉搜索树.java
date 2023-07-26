package 西湖算法题解___简单题;

public class __108将有序数组转换为二叉搜索树 {
	public static void main(String[] args) {

	}//public static void main(String[] args)

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
	}//public class TreeNode


		public TreeNode sortedArrayToBST(int[] nums) {
			return dfs(nums,0,nums.length-1);
		}//public TreeNode sortedArrayToBST(int[] nums)

	private TreeNode dfs(int[] nums, int left, int right) {
		if (left > right){
			return null;
		}
		/**
		 * 设计很巧妙，因为默认本来就是一个有序数组，那么通过思考可以发现：
		 * 最初的node一定是，这一组数中，中间那个元素
		 *                          而其左边那个元素，一定是它左边那组数中正中间的元素
		 *                          而其右边那个元素，一定是它右边那组数中正中间的元素
		 * 根据这个规律，再结合dfs往下遍历，即可生成整个树的轮廓。
		 */
		int mid = left + (right-left)/2;    //这样取中间值，可以防止数据过大时，导致相加后数据溢出问题。
		TreeNode node = new TreeNode(nums[mid]);    //给node赋值。
		node.left = dfs(nums,left,mid-1);
		node.right = dfs(nums,mid+1,right);
		return node;
	}//private TreeNode dfs(int[] nums, int left, int right)
}//public class __108将有序数组转换为二叉搜索树
