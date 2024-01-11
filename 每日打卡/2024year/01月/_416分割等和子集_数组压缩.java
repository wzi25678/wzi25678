package 代码随想录.动态规划;

import java.util.Arrays;

public class _416分割等和子集_数组压缩 {
    /**
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
        int allSum = Arrays.stream(nums).sum();
        if (allSum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = allSum / 2;
        int [] dp = new int[target + 1];
        for (int i = 0;i< nums.length;i++){
            for (int j = target;j>= nums[i];j--){
                //物品i的重量是nums[i],其价值也是nums[i]
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
            //剪枝一下，每一次完成内层的for-loop，立即检查是否dp[target] == target
            if (dp[target] == target){
                return true;
            }
        }
        return dp[target] == target;
    }
}
