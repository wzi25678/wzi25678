package 代码随想录.贪心算法;

public class _121买卖股票的最佳时机 {
    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //计算差值，暴力购买
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit){
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit>0?maxProfit:0;
    }
}
