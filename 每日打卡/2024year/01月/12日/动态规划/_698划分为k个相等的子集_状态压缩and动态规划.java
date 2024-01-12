package 代码随想录.动态规划;

import java.util.Arrays;

public class _698划分为k个相等的子集_状态压缩and动态规划 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int allSum = Arrays.stream(nums).sum();
        if (allSum % k != 0) {  //如果不能k等分，则说明无法实现对应的要求
            return false;
        }
        int person = allSum / k;    //算出每个人的均分获得值
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n-1] > person) {
            return false;
        }
        boolean [] dp = new boolean[1 << n];   //1 <= k <= len(nums) <= 16
        int [] curSum = new int[1 << n];
        dp[0] = true;
        for (int i = 0;i < 1<<n;i++){
            if (!dp[i]){
                continue;
            }
            for (int j = 0;j < n;j++){
                if (curSum[i] + nums[j] > person){
                    break;
                }
                if (((i >> j) & 1) == 0){
                    int next = i | (1 << j);
                    if (!dp[next]){
                        curSum[next] = (curSum[i] + nums[j]) % person;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
