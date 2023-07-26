package 西湖算法题解___简单题;

public class __101对称二叉树 {
	public static void main(String[] args) {}

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
  }// public class TreeNode


	public boolean isSymmetric(TreeNode root) {
		//1.递归判断
		if (root==null){
			return true;
		}

		return CompareIsSymmetric(root.left,root.right);

	}

	private boolean CompareIsSymmetric(TreeNode left, TreeNode right) {
		//全空则为true
		if (left==null && right==null){
			return true;
		}
		//一个为空，另一个不为空，则一定是false
		if (left == null || right == null){
			return false;
		}
		//如果上面都满足了，则说明该结点的左右结点均存在
		//但是需要注意，如果左右结点相等，还是无法肯定它们就是对称树，但如果左右节点不相等，则它们一定是非对称树
		if (left.val != right.val){
			return false;
		}
		//如果相等，则继续往下递归
		//这里递归也需要注意，即左边的左，对应右边的右；；；；；；左边的右，对应右边的左
		return CompareIsSymmetric(left.left,right.right) && CompareIsSymmetric(left.right,right.left);
	}
}
