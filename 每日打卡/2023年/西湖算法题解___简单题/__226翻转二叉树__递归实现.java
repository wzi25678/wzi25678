package 西湖算法题解___简单题;

public class __226翻转二叉树__递归实现 {
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

	public TreeNode invertTree(TreeNode root) {
		//类似于前面提到的对称二叉树
		if (root == null){
			return null;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
}
