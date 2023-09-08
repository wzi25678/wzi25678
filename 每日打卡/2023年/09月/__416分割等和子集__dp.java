package 西湖算法题解___中等题;

public class __416分割等和子集__dp {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		if (n<2){
			return false;
		}
		int sum = 0,maxNum = 0;
		for (int num:nums){
			sum += num;
			maxNum = Math.max(maxNum,num);      //还需要找到最大的元素
		}
		int total_half = sum/2;
		if (sum % 2 != 0){      //首先就是总和一定得满足是偶数才可能。
			return false;
		}
		//少算一点，，
		//如果最大值，大于一半的值，那么必然是false;
		if(maxNum > total_half){
			return false;
		}
		boolean [][] dp = new boolean[n][total_half + 1];
		for (int i=0;i<n;i++){
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i=1;i<n;i++){
			int num = nums[i];
			for (int j=1;j<=total_half;j++){
				if (j >= num){
					dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n-1][total_half];
	}
}
