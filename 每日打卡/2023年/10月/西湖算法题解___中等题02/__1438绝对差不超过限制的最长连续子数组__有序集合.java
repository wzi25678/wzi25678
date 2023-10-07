package 西湖算法题解___中等题02;

import java.util.TreeMap;

public class __1438绝对差不超过限制的最长连续子数组__有序集合 {
	public static void main(String[] args) {
		/*
			1 <= nums.length <= 10^5
			1 <= nums[i] <= 10^9
			0 <= limit <= 10^9
		 */
	}
	/**
	 *
	 * @param nums
	 * @param limit
	 * @return
	 */
	public int longestSubarray(int[] nums, int limit) {
		//任意两元素差的abs    <= limit
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int n  = nums.length;
		int left = 0,right = 0;
		int res = 0;
		while (right < n){
			map.put(nums[right],map.getOrDefault(nums[right],0)+1 );
			while (map.lastKey() - map.firstKey() > limit){
				map.put(nums[left], map.get(nums[left] )- 1);
				if (map.get(nums[left]) == 0){
					map.remove(nums[left]);
				}
				left++;
			}
			res  = Math.max(res,right - left + 1);
			right++;
		}
		return res;
	}
}
