package 代码随想录.贪心算法;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _1005K次取反后最大化的数组和_Stream流 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((a, b) -> Math.abs(b) - Math.abs(a))    //从大到小,降序
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k >0){
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (k % 2 == 1){
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
