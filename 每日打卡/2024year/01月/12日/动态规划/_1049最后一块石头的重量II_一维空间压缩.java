package 代码随想录.动态规划;

import java.util.Arrays;

public class _1049最后一块石头的重量II_一维空间压缩 {
    /**
     * 每次都去找最小差
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        sum = Arrays.stream(stones).sum();
        int target = sum >> 1;
        //初始化dp数组
        int [] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i];j--){
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2*dp[target];
    }
}
