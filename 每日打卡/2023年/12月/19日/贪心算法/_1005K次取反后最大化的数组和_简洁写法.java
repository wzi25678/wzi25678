package 代码随想录.贪心算法;

import java.util.Arrays;

public class _1005K次取反后最大化的数组和_简洁写法 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (k>0 && num < 0){
                num = -num;
                k--;
            }
        }
        Arrays.sort(nums);
        return Arrays.stream(nums).sum() - (k%2 == 0 ? 0 : nums[0] * 2);
    }
}
