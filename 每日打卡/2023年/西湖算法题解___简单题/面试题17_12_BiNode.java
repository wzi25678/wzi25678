package 西湖算法题解___简单题;

public class 面试题17_12_BiNode {
	  public class TreeNode {
		     int val;
			 TreeNode left;
			 TreeNode right;
			 TreeNode(int x) { val = x; }
        }

		TreeNode head = new TreeNode(-1);   //为了返回单向链表的头节点而多设的节点
		TreeNode prev = null;   //指向当前节点的前一个节点

	public TreeNode convertBiNode(TreeNode root) {
		InOrder(root);
		return head.right;
	}

	private void InOrder(TreeNode root) {
		//进行中序遍历，可以实现 一个有序查找
		if (prev == null){
			prev = root;
		}
		InOrder(root.left);
		prev.right = root;
		prev.left = null;
		InOrder(prev.right);
	}

}



