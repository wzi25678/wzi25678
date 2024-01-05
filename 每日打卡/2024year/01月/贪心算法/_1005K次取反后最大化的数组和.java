package 代码随想录.贪心算法;

import java.util.Arrays;

public class _1005K次取反后最大化的数组和 {
    /**
     *
     * @param nums
     * @param k     k为固定需要变化K次
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        /*  变化思路：
                优先选择负数进行变正
                如果还不够则考虑选择绝对值最小的正数，来回变化，抵消剩余次数。
         */
        // TODO 可以考虑使用Arrays.sort()  找出可以变成负数的值，同时看看数量是否有多；有多，则Math.abs()交替
        //  如果前k个数全部小于0，直接反转，如果k有剩余，则反转最小值
        Arrays.sort(nums);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length; i++){
            if (k==0){
                break;
            }
            if (nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
            if (minValue > nums[i]){
                //如果当前绝对值比minValue小
                minValue = nums[i];
            }
        }
        int result = 0;
        if (k%2==0){
            for (int num:nums){
                result+=num;
            }
        }else {
            for (int num:nums){
                result+=num;
            }
            result-=(2*minValue);
        }
        return result;
    }
}
