package 日常Java程序测试.代码随想录.数组;

public class __283移动零__检测非0 {
	/**
	 *
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int nLength = nums.length,left = 0,right = 0;
		while (right < nLength){
			if (nums[right]!=0){    //right指示遍历的每一个元素，left指示非0位置
				//每检测到一个非0元素，我就让他和第1,2,3,4,5,6...这些个元素互换位置，同时也不用担心顺序问题，因为我换的时候就是按顺序遍历
				mySwap(nums,left,right);
				++left;
			}
			++right;
		}
	}

	/**
	 *
	 * @param nums
	 * @param left
	 * @param right
	 */
	private void mySwap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
