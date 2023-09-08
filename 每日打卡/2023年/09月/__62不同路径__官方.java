package 西湖算法题解___中等题;

public class __62不同路径__官方 {
	public int uniquePaths(int m, int n){
		int [][]  dp = new int[m][n];
		for (int i=0;i<m;i++){
			dp[i][0] = 1;   //第一列只能向下走的情况下，所以走法是1
		}
		for (int i=0;i<m;i++){
			dp[0][i] = 1;   //第一行只能向右走的情况下，所以走法是1
		}

		//逐行逐列计算走法数量
		for (int i=1;i<m;i++){
			for (int j=1;j<n;j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
}
