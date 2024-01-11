package 代码随想录.动态规划;

public class _474一和零 {
    /**
     *
     * @param strs :二进制字符串集合
     * @param m： 集合中最多包含m个0
     * @param n： 集合中最多包含n个1
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // TODO 问，满足该条件的二进制数组中，最多能够包含多少个子集
        // 优先考虑选取最短的字符串子集?
        /**
         不少同学刷过这道题，可能没有总结这究竟是什么背包。

         此时我们讲解了0-1背包的多种应用，

         纯 0 - 1 背包 (opens new window)是求 给定背包容量 装满背包 的最大价值是多少。
         416. 分割等和子集 (opens new window)是求 给定背包容量，能不能装满这个背包。
         1049. 最后一块石头的重量 II (opens new window)是求 给定背包容量，尽可能装，最多能装多少
         494. 目标和 (opens new window)是求 给定背包容量，装满背包有多少种方法。
         本题是求 给定背包容量，装满背包最多有多少个物品。
         所以在代码随想录中所列举的题目，都是 0-1背包不同维度上的应用，大家可以细心体会！
         */
        //dp[i][j]表示i个0和j个1时的最大子集
        int [][] dp = new int[m+1][n+1];    //记录使用任意个0,1时，所能产生的最大集合数量
        for (String str:strs){
            //对每一个子集都要记录它们的0,1个数
            int oneNum=0,zeroNum=0;
            for (char ch :str.toCharArray()){
                if (ch == '0'){
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            //上述记录出了每一个子集对应的0,1个数，然后传入到dp数组中，去做比较
            //判断当前个数子集下的最少使用0,1个数

            //将每一次的统计结果，记入，比较存储进dp中
            //采用倒序遍历
            for (int i = m; i >= zeroNum; i--){
                for (int j = n;j>=oneNum;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
