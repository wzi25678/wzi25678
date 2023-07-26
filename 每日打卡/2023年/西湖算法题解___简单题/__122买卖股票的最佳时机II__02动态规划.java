package 西湖算法题解___简单题;

public class __122买卖股票的最佳时机II__02动态规划 {
	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices){
		int dp[][] = new int[prices.length][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i=1;i< prices.length;i++){
			dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
			dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
		}
		return dp[prices.length-1][0];


	}
}
