package 代码随想录.动态规划;

import java.util.Arrays;

public class _473火柴拼正方形_状态压缩and动态规划 {
    /**
     *
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int allSum = Arrays.stream(matchsticks).sum();
        if (allSum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int len = allSum / 4 ;
        int n = matchsticks.length;
        int [] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0;k<n;k++){
                if ((s & (1 << k)) == 0){
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len){
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1<<n) -1] == 0;
    }
}
