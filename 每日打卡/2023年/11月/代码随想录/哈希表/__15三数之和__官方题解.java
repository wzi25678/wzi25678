package 日常Java程序测试.代码随想录.哈希表;

import java.util.*;

public class __15三数之和__官方题解 {
	/**
	 *  3 <= nums.length <= 3000
	 *  //那这里就不行暴力三个for了
	 * -10^5 <= nums[i] <= 10^5
	 *
	 *
	 * 三个数的话，可以仿造之前四个数的搞一下
	 * 然后这道题也没有时间要求，基本就是自己随便玩
	 * 然后结果集的话，需要构建一个链表
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//这道题是一个数组里面找三个值
		/*
		先将原来的元素排好序的话，可以减少大量的重复操作
		 */
		int n = nums.length;
		Arrays.sort(nums);
		//枚举所有a
		for (int first = 0;first<n;++first){
			//需要和上次枚举的数不相同
			if (first > 0 && nums[first] == nums[first-1]){
				continue;
			}
			//c对应的指针初始化指向数组的最右端
			int third = n - 1;
			int target = -nums[first];
			//枚举b
			for (int second = first+1;second<n;++second){
				//需要和上次枚举的数不相同
				if (second > first + 1 && nums[second] == nums[second - 1]){
					continue;
				}
				//需要保证b的指针在c的指针的左侧
				while (second<third && nums[second] + nums[third] > target){
					--third;
				}
				//如果指针重合，随着b后续的增加
				//就不会有满足a+b+c=0，并且b<c的c了，此时就可以退出循环
				if (second == third){
					break;
				}
				if (nums[second] + nums[third] == target){
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					res.add(list);
				}
			}
		}
		return res;
	}
}
