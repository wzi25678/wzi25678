package 代码随想录.动态规划.小总结240411;

import java.util.Arrays;

public class _416分割等和子集_dp {
    /**
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        // TODO 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
        int len = nums.length;
        if (len == 1){
            return false;
        }
        int allSum = Arrays.stream(nums).sum();
        if (allSum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = allSum / 2;
        //初始化dp数组
        int dp [][] = new int[nums.length][target + 1];
        //初始化dp数组元素
        for(int j = 0; j <= target; j++){
            if(j < nums[0]){
                dp[0][j] = 0;
            }
            else{
                dp[0][j] = nums[0];
            }
        }
//        for(int j = 0; j <= target; j++){
//            dp[0][j] = nums[0];
//        }
        //开始动态规划一下
        for (int i = 1;i<len;i++){
            for (int j  = 0;j<=target;j++){
                if (j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - nums[i]] + nums[i]);
                }
            }
        }
        //打印出来给你自己看看
        // for(int x : dp){
        //     System.out.print(x + ",");
        // }
        // System.out.print("    "+i+" row"+"\n");
        return dp[len-1][target]  ==  target;
    }

}
