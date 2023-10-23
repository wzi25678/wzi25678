package 日常Java程序测试.代码随想录.数组;

import java.util.Arrays;

public class __209长度最小的子数组_nlogn_n {
	public int minSubArrayLen(int target, int[] nums) {
		//找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组
		/**
		 1 <= target <= 109
		 1 <= nums.length <= 105
		 1 <= nums[i] <= 105

		 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
		 */
		int n = nums.length;
		if (n == 0){
			return 0;
		}
		int res = Integer.MAX_VALUE;
		int sums [] = new int[n + 1];   //每一个都对应前面所有nums[]的和。
		for (int i = 1;i<=n;i++){
			sums[i] = sums[i - 1] + nums[i-1];
		}
		for (int i = 1;i<=n;i++){
			int tar = target + sums[i-1];   //每一个合，都加上target
			int bound = Arrays.binarySearch(sums,tar);
			if (bound < 0){
				bound = -bound - 1;
			}
			if (bound <= n){
				res = Math.min(res,bound - (i-1));
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
