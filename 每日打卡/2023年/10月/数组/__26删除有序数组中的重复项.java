package 日常Java程序测试.代码随想录.数组;

public class __26删除有序数组中的重复项 {
	/**
	 *
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		//请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
		//nums 已按 非严格递增 排列
		int n = nums.length;
		if (n == 0){
			return 0;
		}
		int slowPoint = 1,fastPoint = 1;
		while (fastPoint < n){
			if (nums[fastPoint] != nums[fastPoint - 1]){    //不是相同元素
				nums[slowPoint] = nums[fastPoint];
				++slowPoint;
			}
			++fastPoint;
		}
		return slowPoint;
	}

}
