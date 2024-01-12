package 代码随想录.动态规划;

public class _518零钱兑换II {
    /**
     *
     * @param amount :总金额
     * @param coins :不同面额的硬币
     * @return  请你计算并返回可以凑成总金额的硬币组合数。
     */
    public int change(int amount, int[] coins) {
        // TODO 递推表达式
        int [] dp = new int[amount + 1];
        //初始化模拟出所有金额的给出方案
        //其实0时，认为有一种方案，即什么都不放
        dp[0] = 1;
        for (int i = 0;i<coins.length;i++){ //所有金币
            for (int j = coins[i];j<=amount;j++){   //目标指定金额
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
