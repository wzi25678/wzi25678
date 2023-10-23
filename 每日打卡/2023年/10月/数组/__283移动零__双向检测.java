package 日常Java程序测试.代码随想录.数组;

public class __283移动零__双向检测 {
	/**
	 *
	 * @param nums
	 */
	public void moveZeroes(int[] nums){
		int left = 0,right = 1;
		int end = nums.length - 1;
		while (left <= end && nums[left] != 0){
			left++;
		}
		//右指针指向第一个不为0的数
		for (;right <= end;right++){
			if (right > left && nums[right] != 0){
				nums[left] = nums[right];
				nums[right] = 0;
				left++;
			}
		}
	}
}
