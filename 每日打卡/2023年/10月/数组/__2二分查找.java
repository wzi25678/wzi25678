package 日常Java程序测试.代码随想录.数组;

public class __2二分查找 {
	public int search(int[] nums, int target) {
		/**
		 * 给定一个 n 个元素【有序的（升序）】整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
		 */
		//nums[]数组中，找目标元素target的下标
		if (nums[0] > target ||  nums[nums.length - 1] < target ){
			return -1;
		}
		int low = 0,high = nums.length-1;   //low,high取得是下标啊
		while (low<=high){
			int mid = low + ((high-low) >> 1);
			if (nums[mid] == target){
				return mid;
			} else if (nums[mid] > target) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
}
