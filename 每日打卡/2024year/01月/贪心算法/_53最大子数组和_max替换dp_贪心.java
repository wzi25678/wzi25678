package 代码随想录.贪心算法;

public class _53最大子数组和_max替换dp_贪心 {
    /**
     * //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 跟之前遇到的买股票的类似吧，就是说有正有负，然后找出连续区间总和最大
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //TODO 返回连续和的值
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0;i< nums.length;i++){
            count += nums[i];
            sum = Math.max(sum,count);  // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count < 0){     //负数则重置累积count
                count = 0;
            }
        }
        return sum;
    }
}
