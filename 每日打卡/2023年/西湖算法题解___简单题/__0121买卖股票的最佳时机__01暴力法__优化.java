package 西湖算法题解___简单题;

public class __0121买卖股票的最佳时机__01暴力法__优化 {
	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		int MaxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i=0;i<prices.length;i++){
			if (prices[i] <minPrice ){  //每个数都去判断，自己是不是——————cur最小值
				minPrice = prices[i];
			}
			//每个数都去判断，自己是不是—————可以产生出最大利润。
			if (prices[i]-minPrice > MaxProfit){
				 MaxProfit = prices[i]-minPrice;
			}

		}//for (int i=0;i<prices.length;i++)
		return MaxProfit;
	}

}
