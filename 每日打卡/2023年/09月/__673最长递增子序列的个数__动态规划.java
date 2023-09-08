package 西湖算法题解___中等题;

public class __673最长递增子序列的个数__动态规划 {
	public int findNumberOfLIS(int[] nums) {
		//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
		//注意: 这个数列必须是 严格 递增的。严格大于。
		//注意是返回最长递增子序列的个数
		/**
		 每一个最长递增，都与之前的长度有关
		 */
		int numsLength = nums.length,maxLen = 0,res = 0;
		int dp_findNumberOfLIS [] = new int[numsLength];
		int count [] = new int[numsLength];
		for (int i = 0;i<numsLength;i++){
			dp_findNumberOfLIS[i] = 1;
			count[i] = 1;
			for (int j=0;j<i;j++){
				if (nums[i] > nums[j]){
					if (dp_findNumberOfLIS[j] + 1 > dp_findNumberOfLIS[i]){
						dp_findNumberOfLIS[i] = dp_findNumberOfLIS[j] + 1;
						count[i] = count[j];    //重置计数
					} else if (dp_findNumberOfLIS[j]+1 == dp_findNumberOfLIS[i]) {
						count[i]+=count[j];
					}
				}
			}
			if (dp_findNumberOfLIS[i] > maxLen){
				maxLen = dp_findNumberOfLIS[i];
				res = count[i];     //重制计数
			} else if (dp_findNumberOfLIS[i] == maxLen) {
				res += count[i];
			}
		}
		return res;
	}
}
