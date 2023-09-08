package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __15三数之和__双指针 {
	public static void main(String[] args) {

	}//public static void main(String[] args)

	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//也需要进行枚举
		for (int first = 0;first < n;first++){
			//需要和上一次枚举的数不同
			if (first  > 0  && nums[first] == nums[first-1]){
				//相同则跳过
				continue;
			}
			//不同则继续
			//c 对应的指针初始化指向数组的最右端
			int third = n-1;
			int target = -nums[first];
			//枚举b
			for (int second = first+1;second < n;second++){
				//题目规定了，需要和上一次枚举的数不相同
				if (second > first+1 && nums[second] == nums[second-1]){
					continue;
				}
				//需要保证b的指针在c指针的左侧
				while (second < third && nums[second] + nums[third] > target){
					third--;
				}
				//如果指针重合，随着b后续的增加
				//就不会有满足a+b+c=0，并且b<c的c了，可以退出循环
				if (second == third){
					break;
				}
				if (nums[second] + nums[third]==target){
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					res.add(list);
				}
			}
		}
		return  res;
	}//	public List<List<Integer>> threeSum(int[] nums)
}
