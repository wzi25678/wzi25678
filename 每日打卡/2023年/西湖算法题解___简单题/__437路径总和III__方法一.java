package 西湖算法题解___简单题;

public class __437路径总和III__方法一 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private  int count= 0;
	public int pathSum(TreeNode root, int targetSum){
			/*
			没啥技巧，就是一个BFS，然后用一个res记录每次累加的结果，用一个count记录出现你要的结果的出现次数
			 */
		if(root == null){
			return 0;
		}
		int count = BFStoSum(root,targetSum);
		count += pathSum(root.left,targetSum);
		count += pathSum(root.right,targetSum);
		return count;
	}

	private int BFStoSum(TreeNode root, int targetSum) {
		int res = 0;
		if (root == null){
			return 0;
		}
		int val = root.val;
		if (val==  targetSum){
			res++;
		}
		//等于也得继续调它的左右节点进行累加
		res += BFStoSum(root.left,targetSum - val);
		res += BFStoSum(root.right,targetSum - val);
		return res;
	}
}
