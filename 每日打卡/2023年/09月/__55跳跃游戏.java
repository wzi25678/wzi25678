package 西湖算法题解___中等题;

public class __55跳跃游戏 {
	public static void main(String[] args) {

	}

	private boolean flag;
	/**
	 *
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		/*
		给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

		数组中的每个元素代表你在该位置可以跳跃的最大长度。

		判断你是否能够到达最后一个下标。
		 */
		int n = nums.length;
		int rightMost = 0;
		for (int i=0;i<n;i++){
			if (i<=rightMost){
				rightMost = Math.max(rightMost,i+nums[i]);
				if (rightMost >= n-1){
					return true;
				}
			}
		}
		return false;
//
//		int jumpLength = nums[0];
//		canJumpIt(nums,0,jumpLength);
//		return flag;
	}

	/**
	 *
	 * @param start
	 * @return
	 */
//	private void canJumpIt(int nums[],int curSite,int start) {
//		for (int i=1;i<=start;i++){
//			if (curSite+i== nums.length-1){
//				flag = true;
//				return;
//			}
//			canJumpIt(nums,curSite+i,nums[i]);
//		}
//		flag = false;
//	}




}
