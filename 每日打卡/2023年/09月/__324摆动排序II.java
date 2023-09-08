package 西湖算法题解___中等题;

import java.util.Arrays;

public class __324摆动排序II {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		int new_nums [] = new int[n];
		Arrays.sort(nums);
		int j=n-1;
		for (int i=1;i<n;i+=2,j--){
			new_nums[i] = nums[j];
		}
		for (int i=0;i<n;i+=2,j--){
			new_nums[i] = nums[j];
		}
		for (int i=0;i<n;i++){
			nums[i] = new_nums[i];
		}
	}
}
