package 代码随想录.贪心算法;

public class _122买卖股票的最佳时机II {
    /**
     * //在每一天，你可以决定是否购买和/或出售股票。
     * // 你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // TODO 上一题是求一次交易的，这次是求整个过程可以获得的最大利润
        // 这道题目和1一样，你只要计算出，每个的差值就可以了，只要能赚到钱，都加进去肯定没问题
        int result = 0;
        int n = prices.length;
        for (int i = 1; i<n;i++){
            result += Math.max(0,prices[i] - prices[i-1]);
        }
        return result;
    }
}
