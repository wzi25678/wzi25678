package 西湖算法题解___中等题;


import java.util.ArrayList;
import java.util.List;

public class __95不同的二叉搜索树II {
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
          this.right = right;     }
  }

	/**
	 *
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
		if ( n <= 0){
			return new ArrayList<>();
		}

		return generateTrees(1,n);
	}

	/**
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	private List<TreeNode> generateTrees(int start,int end){
		List<TreeNode> result = new ArrayList<>();
		if (start > end){
			result.add(null);
			return result;
		}
		//-----------------------------------start<=end
		for (int i=start;i<=end;i++){
			List<TreeNode> leftTrees = generateTrees(start,i-1);    //左边都比它小
			List<TreeNode> rightTrees = generateTrees(i+1,end);     //右边都比它大
			for (TreeNode leftTree :leftTrees){
				for (TreeNode rightTree :rightTrees){
					//
					TreeNode rootNode = new TreeNode(i);
					rootNode.left = leftTree;
					rootNode.right = rightTree;
					result.add(rootNode);
				}
			}
		}
		return result;
	}

}
