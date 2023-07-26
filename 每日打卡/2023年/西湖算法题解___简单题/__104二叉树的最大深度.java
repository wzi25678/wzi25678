package 西湖算法题解___简单题;

import java.util.LinkedList;
import java.util.Queue;

public class __104二叉树的最大深度 {
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
	public static void main(String[] args) {
		//想知道一棵树的最大深度，值需要通过层次遍历，
		//即通过层次遍历--->队列--->BFS，获取这棵树有多深，就可以知道它对应的层次。
	}

	public int maxDepth(TreeNode root) {
		  //先判断，再操作
		  if (root == null){
			  return 0;
		  }
		  //队列
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int res = 0;
		//根节点存在,则开始进行层次遍历
		while (!queue.isEmpty()){   //一层一层队列往下进行
			int size = queue.size();//一开始先记录下当前层次应该具有的数目
			while (size > 0){
				TreeNode node = queue.poll();   //队列出来一个数
				if (node.left != null){
					queue.offer(node.left); //左节点有，则让结点的左节点放入到队列中
				}
				if (node.right != null){
					queue.offer(node.right);
				}
				//上面是对一个结点queue.poll() 出来的node进行了左右节点是否存在的判断
				size-=1;
			}//while (size > 0)
			res+=1;
		}
		return res;
	}//public int maxDepth(TreeNode root)


}//public class __104二叉树的最大深度
