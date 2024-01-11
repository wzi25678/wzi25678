package 代码随想录.动态规划;

public class _53最大子数组和_标准dp {
    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }

}
