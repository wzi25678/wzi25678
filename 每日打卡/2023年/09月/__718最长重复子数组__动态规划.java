package 西湖算法题解___中等题;

public class __718最长重复子数组__动态规划 {
	//子数组的话，默认是连续的。
	public int findLength(int[] nums1, int[] nums2) {
		/*
		给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
		当然了，肯定是要求顺序，而非连续。
		那么必然就需要用到动态数组，采取累积的形式

		 */
		int n = nums1.length,m = nums2.length;
		int dp_findLength [][] = new int[n+1][m+1];
		int res = 0;
		for (int i=n-1;i>=0;i--){
			for (int j=m-1;j>=0;j--){
				dp_findLength[i][j] = (nums1[i] == nums2[j] ? dp_findLength[i+1][j+1] + 1:0);
				res = Math.max(res,dp_findLength[i][j]);
			}
		}
		return res;
	}
}
