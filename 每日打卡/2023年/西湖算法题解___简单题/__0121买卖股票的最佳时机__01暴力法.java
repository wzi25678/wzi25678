package 西湖算法题解___简单题;

public class __0121买卖股票的最佳时机__01暴力法 {
	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		int ans = 0;
		int max = Integer.MIN_VALUE;
		for (int i=0;i<prices.length;i++){
			for (int j=i+1;j< prices.length;j++){
				int begin = prices[i];
				int cur_max = prices[i];
				if (cur_max < prices[j]){   //说明可以赚到钱
					ans = prices[j]-begin;
					if (ans > max){
						max = ans;
					}
					cur_max = prices[j];
				}
			}//for (int j=i+1;j< prices.length;j++)
		}//for (int i=0;i<prices.length;i++)
		if (ans==0){
			return 0;
		}
		return max;

	}


}
