package 西湖算法题解___简单题;

public class _1_两数之和03 {

	private static int[] towSum(int[] nums, int target){
		long helper[][] = new long[10002][2];
		for (int i=0;i<nums.length;i++){
			helper[nums[i]][0] = 1 ;
			helper[nums[i]][1] = i;
		}
		int ans [] = new int[2];
		for (int i=0;i<nums.length;i++){
			if (helper[target-nums[i]][0] == 1){
				ans[0] = i;
				ans[1] = (int) helper[target-nums[i]][1];
			}
		}
		return ans;

	}
}
