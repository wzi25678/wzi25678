package 西湖算法题解___简单题;

public class __0136只出现一次的数字 {
	public static void main(String[] args) {

	}

	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i=0;i<nums.length;i++){
			ans= ans^nums[i];
		}
		return ans;
	}
}
