package 代码随想录.动态规划;

import java.util.Arrays;

public class _494目标和_空间压缩 {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        // TODO 数组元素顺序不变，给每个符号前面，添加上一个 + 或者 - 号。
        int sum = Arrays.stream(nums).sum();    //绝对总和
        //先求出目标总和，如果target过大，sum则无法满足
        if (Math.abs(sum) < Math.abs(target)){
            return 0;
        }
        //sum 与 target必须同奇 或者 同偶
        if ((target + sum) % 2 != 0){
            return 0;
        }
        int size = (target + sum) / 2;
        if (size <  0){
            size = -size;
        }
        int dp [] = new int[size + 1];
        dp[0] = 1;
        for (int  i=0;i< nums.length;i++){
            for (int j  = size;j>=nums[i];j--){
                dp[j]+=dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
