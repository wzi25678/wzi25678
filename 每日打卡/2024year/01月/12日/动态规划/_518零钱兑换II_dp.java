package 代码随想录.动态规划;

public class _518零钱兑换II_dp {
    /**
     *
     * @param amount :总金额
     * @param coins :不同面额的硬币
     * @return  请你计算并返回可以凑成总金额的硬币组合数。
     */
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount + 1];
        //只有一种硬币的情况，做个初始化
        for (int i = 0; i <= amount; i+=coins[0]){
            dp[0][i] = 1;
        }
        for (int i = 1;i<coins.length;i++){
            for (int j = 0;j<=amount;j++){
                //每一种硬币，仅可能的从0~max去尝试使用，进行求和。
                for (int k=0;k*coins[i] <=j;k++){
                    dp[i][j] += dp[i-1][j-k*coins[i]];
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}
