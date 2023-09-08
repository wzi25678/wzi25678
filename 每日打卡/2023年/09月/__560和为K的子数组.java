package 西湖算法题解___中等题;

public class __560和为K的子数组 {
	public int subarraySum(int[] nums, int k) {
		//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
		//和为k的连续子数组个数。
		/*
		1 <= nums.length <= 2 * 104
		-1000 <= nums[i] <= 1000
		-10^7 <= k <= 10^7
		 */
		int count = 0;
		int nLength = nums.length;
		for (int start = 0;start< nLength;start++){
			int sum = 0;
			for (int end = start;end >= 0;end--){
				sum += nums[end];
				if (sum == k){
					count++;
				}
			}
		}
		return count;
	}
}
