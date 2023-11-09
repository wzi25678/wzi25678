package 日常Java程序测试.代码随想录.数组;

public class __27移除元素 {
	/**
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		//不仅要返回的是，剩余长度：返回移除后数组的新长度
		//同时还要变化前对应个数的nums的值
		int n = nums.length;
		int left = 0;
		for (int right = 0;right < n;right++){
			if (nums[right] != val){
				nums[left] = nums[right];
				left++;
			}
		}
		return left;
	}
}
