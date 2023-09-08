package 西湖算法题解___中等题;

import java.util.LinkedList;
import java.util.Queue;

public class __513找树左下角的值__BFS {
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

	int maxHight = 0;       //需要记录获取res时，你对应的height
	int res = 0;

	public int findBottomLeftValue(TreeNode root) {
		//层次遍历肯定行不通啦= =~
/*		//最底层的最左边的元素值
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while ()*/

		/**
		 考虑使用深度优先搜索的话，应该会可行。
		 即，每次bfs，遍历到的第一个就是最终的最深处的最左边的那一个
		 但是同时你需要记录到【当前的高度】。
		 */
		dfs__findBottomLeftValue(root,0);
		return res;
	}

	/**
	 *
	 * @param root          当前位置结点值
	 * @param curHight      当前高度
	 */
	private void dfs__findBottomLeftValue(TreeNode root, int curHight) {
		if (root == null){
			return;
		}
		//那么就要去遍历子节点
		curHight++;
		dfs__findBottomLeftValue(root.left,curHight);
		dfs__findBottomLeftValue(root.right,curHight);
		//左右都走不动了，我们再来判断当前位置结点。
		if (curHight > maxHight){
			maxHight = curHight;
			res = root.val;
		}
	}
}
