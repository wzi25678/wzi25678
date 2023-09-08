package 西湖算法题解___中等题;

import java.util.*;

public class __199二叉树的右视图 {

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

	public List<Integer> rightSideView(TreeNode root) {
		Map<Integer,Integer> rightMostValueAtDepth = new HashMap<Integer,Integer>();
		int max_depth = -1;

		Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
		Deque<Integer> depthStack = new LinkedList<Integer>();
		nodeStack.push(root);
		depthStack.push(0);

		while (!nodeStack.isEmpty()){
			TreeNode node = nodeStack.pop();
			int depth = depthStack.pop();

			if (node != null){
				//维护二叉树的最大深度
				max_depth = Math.max(max_depth,depth);

				//如果不存在对应深度的节点，我们才插入
				if (!rightMostValueAtDepth.containsKey(depth)){
					rightMostValueAtDepth.put(depth,node.val);
				}
				nodeStack.push(node.left);
				nodeStack.push(node.right);
				depthStack.push(depth+1);
				depthStack.push(depth+1);
			}
		}
		List<Integer> rigthView = new ArrayList<Integer>();
		for (int depth=0;depth<=max_depth;depth++){
			rigthView.add(rightMostValueAtDepth.get(depth));
		}
		return rigthView;
	}
}
