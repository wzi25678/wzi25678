package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __15三数之和__暴力法 {
	public static void main(String[] args) {
		int [] nums = new int[]{-1,0,1,2,-1,-4};
		threeSum(nums);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//List<List<Integer>> ans = new ArrayList<List<Integer>>();
		String distinctArr [] ;
		for (int i=0;i< nums.length;i++){
			for (int j=i+1;j< nums.length;j++){
				for (int k=j+1;k< nums.length;k++){
					System.out.printf("此时选择的i、j、k分别为：%d,%d,%d.\n",nums[i],nums[j],nums[k]);
					if (nums[i]+nums[j]+nums[k] == 0){
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[k]);

							res.add(list);

					}
				}
			}
		}
		return res;

	}//public List<List<Integer>> threeSum(int[] nums)
}
