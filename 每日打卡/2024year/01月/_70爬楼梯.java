package 代码随想录.动态规划;

public class _70爬楼梯 {
    /**
     *
     * 1.确定dp数组（dp table）以及下标的含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /*
         * 1.确定dp数组（dp table）以及下标的含义
         dp[n]代表你所有爬楼梯可能的情况；；；n代表爬几节楼梯
         *
         * 2.确定递推公式
         dp[i]怎么得到？？？可以由dp[i-1]上一个台阶，也可以由dp[i-2]上两个台阶
         dp[i] = dp[i-1] + dp[i-2]
         *
         * 3.dp数组如何初始化
         dp[1] = 1,dp[2] = 2
         *
         * 4.确定遍历顺序
         顺序
         *
         * 5.举例推导dp数组
         1,2,3,5,8,13,21,
         */
        int dp[] = new int[n+1];
        //可以再构造一个dp[0] = 1
        dp[0] = 1;
        dp[1] = 1;
        if (n == 1){
            return 1;
        }
        for (int i = 2;i<=n;i++){
            //最后一步已经明确了走几步，所有，整个的走的步数取决于前方未知的dp[i-1], dp[i-2]的可以走的方案数。
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
