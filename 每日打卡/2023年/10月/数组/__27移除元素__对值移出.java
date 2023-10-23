package 日常Java程序测试.代码随想录.数组;

public class __27移除元素__对值移出 {
	/**
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int nLength = 0;
		for (int num:nums){
			if (num == val){
				nLength++;
			}
		}
		return nums.length - nLength;
	}
}
