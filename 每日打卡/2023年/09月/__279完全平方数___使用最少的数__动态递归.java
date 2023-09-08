package 西湖算法题解___中等题;

public class __279完全平方数___使用最少的数__动态递归 {
	public int numSquares(int n) {
		int res = 0;
		int dp [] = new int[n+1];
		for (int i=1;i<=n;i++){
			int min_nums = Integer.MAX_VALUE;
			for (int j=1;j * j <= i;j++){
				//找最大dp数组
				min_nums = Math.min(min_nums,dp[i - j*j]);
			}
			dp[i] = min_nums +1;
		}
		return dp[n];
	}
}
