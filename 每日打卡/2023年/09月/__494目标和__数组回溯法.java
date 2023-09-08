package 西湖算法题解___中等题;

public class __494目标和__数组回溯法 {
	int res = 0;
	public int findTargetSumWays(int[] nums, int target) {
		backTrack(nums,target,0,0);
		return res;
	}

	/**
	 *
	 * @param nums      数组
	 * @param target    目标值
	 * @param index     索引位置
	 * @param curSum    当前累计和
	 */
	private void backTrack(int[] nums, int target, int index, int curSum) {
		//1 <= nums.length <= 20
		//这种方法，属于递归，完全是因为数量级太小了
		//不然肯定算不出来的。
		if (index == nums.length){      //所有元素已经遍历完了
			if (curSum == target){
				res++;
			}
		}else{
			backTrack(nums, target, index+1, curSum+nums[index]);
			backTrack(nums, target, index+1, curSum-nums[index]);
		}
	}


}
