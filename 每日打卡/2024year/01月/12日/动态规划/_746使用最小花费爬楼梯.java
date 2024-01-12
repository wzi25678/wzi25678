package 代码随想录.动态规划;

public class _746使用最小花费爬楼梯 {
    /**
     * 1.确定dp数组（dp table）以及下标的含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        /*
         * 1.确定dp数组（dp table）以及下标的含义
         dp[n]应该用于去表示走到n这个位置的最低花费；；；最终就返回走到Min(n,n-1)的最低花费
         *
         * 2.确定递推公式
         dp[n] = Min(（确定走一步cost[n-1] + dp[n-1]的最低花费）,（确定走两步cost[n-2] + dp[n-2]的最低花费）)
         *
         * 3.dp数组如何初始化
         dp[0] = cost[0],dp[1] = Min(dp[0],dp[1])
         * 4.确定遍历顺序
         顺序
         * 5.举例推导dp数组
         cost = [1,100,1,1,1,100,1,1,100,1]
                 1,100,2,3,3,4,  4,5,5  ,6
         */
        int dp [] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i<cost.length;i++){
            //走到哪儿，就要给他头上的这么多路费。
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
    }
}
