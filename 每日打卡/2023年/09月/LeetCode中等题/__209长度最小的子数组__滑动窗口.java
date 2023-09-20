package LeetCode中等题;

public class __209长度最小的子数组__滑动窗口 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        //--------------------------------------
        int res = Integer.MAX_VALUE;
        int  start = 0,end=0;
        int sum = 0;
        while(end < n){
            sum += nums[end];
            while (sum > target){
                res = Math.min(res,end -start +1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}
