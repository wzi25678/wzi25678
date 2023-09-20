package LeetCode中等题;

import java.util.Arrays;

public class __215数组中的第K个最大元素__调库进行插入排序 {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //快速排序可以最快速的找出     第K大数
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


}
