package 西湖算法题解___简单题;

public class __53最大子数组和03_动态规划 {
	public static void main(String[] args) {

	}

	public int maxSubArray(int[] nums) {
		int pre = 0, maxAns = nums[0];
		for (int x : nums) {
			pre = Math.max(pre + x, x);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}
}
