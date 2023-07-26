package 西湖算法题解___简单题;

public class __122买卖股票的最佳时机II__01贪心思想 {
	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		//采用贪心思想，即每一段上涨曲线，我都认为它实现了：当即购买，一涨就抛售
		int ans = 0;
		for (int i=1;i< prices.length;i++){
			ans+= Math.max(0,prices[i]-prices[i-1]);
		}
		return ans;
	}
}
