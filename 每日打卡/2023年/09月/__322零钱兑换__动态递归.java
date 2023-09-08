package 西湖算法题解___中等题;

import java.util.Arrays;

public class __322零钱兑换__动态递归 {
	public int coinChange(int[] coins, int amount) {
		int max = amount +1;
		int dp_coins [] = new int[amount + 1];
		Arrays.fill(dp_coins,max);
		dp_coins[0] = 0;
		for (int i=1;i<=amount;i++){
			for (int j=0;i<coins.length;j++){
				if (coins[j] <= i){
					dp_coins[i] = Math.min(dp_coins[i],dp_coins[i - coins[j]] + 1);
				}
			}
		}
		return dp_coins[amount] > amount ? -1 :dp_coins[amount];
	}
}
