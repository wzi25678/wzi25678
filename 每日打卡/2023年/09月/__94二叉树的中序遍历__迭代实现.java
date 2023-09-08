package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class __94二叉树的中序遍历__迭代实现 {
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

	List<Integer> res = new ArrayList<Integer>();
	public List<Integer> inorderTraversal(TreeNode root) {
		//递归的本质就是调用栈
		if (root == null){
			return res;
		}

		Stack<TreeNode> stack = new Stack();
		TreeNode head = root;
		while (head !=null || !stack.isEmpty()){
			//中序遍历类似
			while (head != null){
				stack.push(head);
				head = head.left;
			}

			//当前节点的左节点为空
			TreeNode node = stack.pop();
			res.add(node.val);
			head = node.right;
		}
		return res;
	}
}
