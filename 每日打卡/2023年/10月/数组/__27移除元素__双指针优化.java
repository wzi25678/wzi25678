package 日常Java程序测试.代码随想录.数组;

public class __27移除元素__双指针优化 {
	/**
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		//不考虑剩余元素的值
		int left = 0;
		int right = nums.length;
		while (left < right){
			if (nums[left] == val){
				nums[left] = nums[right - 1];
				right--;
			}else {
				left++;
			}
		}
		return left;
	}
}
