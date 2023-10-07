package 西湖算法题解___中等题02;

import java.util.Arrays;

public class __1658将x减到0的最小操作数 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @param x
	 * @return
	 */
	public int minOperations(int[] nums, int x) {
		int n = nums.length;
		int sum = Arrays.stream(nums).sum();
		if (sum < x){
			return -1;
		}
		int right = 0;
		int lSum = 0,rSum = sum;
		int res = n + 1;
		for (int left = -1;left < n;left++){
			if (left != -1){
				lSum += nums[left];
			}
			while (right < n && lSum + rSum > x){
				rSum -= nums[right];
				++right;
			}
			if (lSum + rSum == x){
				res = Math.min(res,(left + 1) + (n - right));
			}
		}
		return res > n? -1 :res;
	}
}
