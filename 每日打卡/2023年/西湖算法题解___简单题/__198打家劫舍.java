package 西湖算法题解___简单题;

public class __198打家劫舍 {
	public static void main(String[] args) {
		//就像前面说的一样，很明显是一个动态规划的题目

	}

	public int rob(int[] nums){
		//排除掉极端情况
		if (nums == null || nums.length ==0){
			return 0;
		}
		if (nums.length==1){
			return nums[0];
		}
		//接下来就是有多家的情况
		int prev = nums[0],cur = Math.max(nums[0],nums[1]);
		for (int i=2;i< nums.length;i++){
			int temp = cur;
			cur =  Math.max(cur,prev+nums[i]);
			prev = temp;
		}
		return cur;
	}
}
