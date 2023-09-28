package 西湖算法题解___中等题02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class __987二叉树的垂序遍历 {
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

	/**
	 题目解释，即按输入构造出一个二叉树
	 然后对树中的节点，赋予（row、col）
	 左移row-1，右移row+1
	 向下则col+1

	 然后按col从小到大，再按row从小到大输出。

	 我们可以从根节点开始，对整棵树进行一次遍历，
	 在遍历的过程中使用数组 nodes记录下每个节点的行号 row，列号 col以及值 value。
	 在遍历完成后，我们按照 col为第一关键字升序，row为第二关键字升序，value为第三关键字升序，对所有的节点进行排序即可。
	 在排序完成后，我们还需要按照题目要求，将同一列的所有节点放入同一个数组中。
	 因此，我们可以对 nodes进行一次遍历，并在遍历的过程中记录上一个节点的列号 lastcol。
	 如果当前遍历到的节点的列号 col 与 lastcol相等，则将该节点放入与上一个节点相同的数组中，否则放入不同的数组中。

	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<int []> nodes = new ArrayList<int []>();
		dfs_垂序遍历(root,0,0,nodes);   //dfs的过程中，要记录下每个节点的row值，和col值.
		Collections.sort(nodes, new Comparator<int[]>() {   //定义出比较器方法
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]){
					return o1[0] - o2[0];
				} else if (o1[1]!=o2[1]) {
					return o1[1] - o2[1];
				}else {
					return o1[2] - o2[2];
				}
			}
		});
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int size = 0;
		int lastCol = Integer.MIN_VALUE;
		for (int [] tuple : nodes){
			int col = tuple[0],row = tuple[1],value = tuple[2];
			if (col != lastCol){
				lastCol = col;
				res.add(new ArrayList<Integer>());
				size++;
			}
			res.get(size - 1).add(value);
		}
		return res;
	}

	private void dfs_垂序遍历(TreeNode curNode, int row, int col, List<int[]> nodes) {
		if (nodes == null){
			return;
		}
		nodes.add(new int[]{col,row,curNode.val});
		dfs_垂序遍历(curNode.left,row+1, col - 1, nodes);
		dfs_垂序遍历(curNode.right,row+1, col + 1, nodes);
	}
}
