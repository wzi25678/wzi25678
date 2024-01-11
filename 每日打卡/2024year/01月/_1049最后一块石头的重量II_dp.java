package 代码随想录.动态规划;

import java.util.Arrays;

public class _1049最后一块石头的重量II_dp {
    /**
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int allSum = 0;
        allSum = Arrays.stream(stones).sum();
        int targetHalf = allSum / 2;
        //初始化，dp[i][j]为可以放0-i物品，背包容量为j的情况下背包中的最大价值
        int [][] dp = new int[stones.length][targetHalf+1];
        //dp[i][0]默认初始化为0
        //dp[0][j]取决于stones[0]
        for (int j = stones[0];j<=targetHalf;j++){
            dp[0][j] = stones[0];
        }

        for (int i = 1;i<stones.length;i++){
            for (int j =1;j<=targetHalf;j++){   //范围为+1，因此可以取到等号
                if (j >= stones[i]){
                    //不放:dp[i - 1][j] 放:dp[i - 1][j - stones[i]] + stones[i]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]] + stones[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[stones.length - 1][targetHalf]);
        return (allSum - dp[stones.length-1][targetHalf]) - dp[stones.length - 1][targetHalf];
    }
}
