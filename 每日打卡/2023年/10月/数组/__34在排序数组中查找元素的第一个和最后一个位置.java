package 日常Java程序测试.代码随想录.数组;

public class __34在排序数组中查找元素的第一个和最后一个位置 {
	/**
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		int leftIndex = binarySearch(nums,target,true);
		int rightIndex = binarySearch(nums,target,false) - 1;
		if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
			return new int[]{leftIndex,rightIndex};
		}
		return new int[]{-1,-1};
	}

	/**
	 *
	 * @param nums
	 * @param target
	 * @param lower
	 * @return
	 */
	private int binarySearch(int[] nums, int target, boolean lower) {
		int left = 0,right = nums.length - 1,res = nums.length;
		while (left <= right){
			int mid = (left + right) / 2;
			if (nums[mid] > target || (lower && nums[mid] >= target)){
				right = mid - 1;
				res = mid;
			}else {
				left = mid + 1;
			}
		}
		return res;
	}
}
