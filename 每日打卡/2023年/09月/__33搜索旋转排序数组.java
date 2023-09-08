package 西湖算法题解___中等题;

public class __33搜索旋转排序数组 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		/*
		这道题描述的有点不知所云，简单点那就是：
		你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
		问题是：    一堆不算太完全有序的数里面去找到一个数
		 */
		if (nums.length == 0){
			return -1;
		}
		if (nums.length==1){
			return nums[0] == target ? 0:-1;
		}
		int left = 0,right = nums.length-1;
		while (left<=right){
			int mid = left+(right-left)/2;
			if (nums[mid] == target){
				return mid;
			}
			if (nums[0] <= nums[mid]){
				if (nums[0] <= target && target < nums[mid]){
					right = mid -1;
				}else {
					left = mid +1;
				}
			}else{//here-01
				if (nums[mid] < target && target <= nums[nums.length-1]){
					left = mid + 1;
				}else {
					right = mid -1;
				}
			}//else{//here-01
		}//while (left<=right){
		return -1;
	}
}
