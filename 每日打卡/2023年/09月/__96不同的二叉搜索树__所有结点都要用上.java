package 西湖算法题解___中等题;

public class __96不同的二叉搜索树__所有结点都要用上 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		if (n<=0){
			return 0;
		}

		int [] dp_numTrees = new int[n+1];
		dp_numTrees[0] = 1;
		dp_numTrees[1] = 1;
		for (int i=2;i<=n;i++){
			for (int j=0;j<i;j++){
				dp_numTrees[i] += dp_numTrees[j] * dp_numTrees[i-j-1];
			}
		}
		return dp_numTrees[n];
	}

}
