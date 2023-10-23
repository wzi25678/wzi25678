package 日常Java程序测试.代码随想录.数组;

public class __35搜索插入位置 {
	/**
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchInsert(int[] nums, int target) {
		//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
		//如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
		/**
		 * 通俗点说，就是有则返回索引下标，没有则将target插入到结尾。
		 */
		int n = nums.length;
		int left = 0,right = n - 1,res = n;
		while (left <= right){
			int mid = ((right - left) >> 1) + left;
			if (target <= nums[mid]){
				res = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return res;
	}
}
