package 代码随想录.动态规划;

public class _509斐波那契数 {
    /**
     * 1.确定dp数组（dp table）以及下标的含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     * @param n
     * @return
     */
    public int fib(int n) {
        //用动态规划的意思实现fib
        /*
         * 1.确定dp数组（dp table）以及下标的含义
         dp[]即每一个 fibN的值，下标代表是第几个
         *
         * 2.确定递推公式
         从第三个fib开始，每一个等于前两个fibN的和
         *
         * 3.dp数组如何初始化
         初始化对象为dp[0]和dp[1]，皆为1
         *
         * 4.确定遍历顺序
         dp[i] = dp[i-1]+dp[i-2]，i>=2
         *
         * 5.举例推导dp数组
         1,1,2,3,5,8,13,21,35,56,91
         *
         */
        //题目中，输入的2；；；对应的其实是，本dp中的3
        int dp[] = new int[n+1];
        dp[0] = 0;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;
        if (n == 1){
            return 1;
        }
        for (int i = 2;i<=n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
