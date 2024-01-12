package 代码随想录.动态规划;

import java.util.Arrays;

public class _698划分为k个相等的子集_状态压缩and记忆化搜索 {
    private int [] nums;
    private int person,n;
    boolean [] dp;
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // TODO 将一个数组分解成，k个独立的子集合，并且这k个子集合数值大小均相等
        this.nums = nums;
        int allSum = Arrays.stream(nums).sum();
        if (allSum % k != 0) {  //如果不能k等分，则说明无法实现对应的要求
            return false;
        }
        person = allSum / k;    //算出每个人的均分获得值
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n-1] > person){
            return false;
        }
        dp = new boolean[1 << n];   //1 <= k <= len(nums) <= 16
        Arrays.fill(dp,true);
        return dfs((1 << n) - 1,0);
    }
    /**
     *
     * @param s 我们可以用一个整数S来表示当前可用的数字集合
     * @param p 用到第几个元素
     * @return
     */
    private boolean dfs(int s , int p) {
        if (s == 0){
            return true;
        }
        if (!dp[s]){
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0;i<n;i++){
            if (nums[i] + p > person){
                break;
            }
            if (((s >> i) & 1) != 0){
                if (dfs(s ^ (1 << i),(p + nums[i]) % person)){
                    return true;
                }
            }
        }
        return false;
    }
}
