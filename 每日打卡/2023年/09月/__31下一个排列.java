package 西湖算法题解___中等题;

public class __31下一个排列 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		int i  = nums.length - 2;
		/*
		从后面往前找第一个，前面大于后面的数，的i的位置。
		 */
		while (i >= 0 &&nums[i]>=nums[i+1]){
			i--;
		}
		//找到第一个前面的数比后面的数小
		if (i >=0){
			int j = nums.length  - 1;
			/*
			j一开始是最后一个位置上的元素，然后找到第一个i小于j，
			即从前往后找，第一个小于前面小于后面的数
			 */
			while(j>0 &&  nums[i] >= nums[j]){
				j--;
			}
			swapNumb(nums,i,j);
		}
		myReverse(nums,i+1);

	}

	/**
	 *
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swapNumb(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 *
	 * @param nums
	 * @param start
	 */
	private void myReverse(int[] nums, int start) {
		int left = start,right = nums.length - 1;
		while (left < right){
			swapNumb(nums,left,right);
			left++;
			right--;
		}
	}
}
