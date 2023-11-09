package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class __1两数之和 {
	/**
	 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
	 *  只会存在一个有效答案
	 *
	 * 两数之和，主要要实现的就是，我怎么快速在一堆数里面，找一个数
	 * 那就需要用到集合
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		//然后这道题，还要返回下标，那么你就可以key等于nums[i]，v等于i
		Map<Integer,Integer> haveNum = new HashMap<Integer,Integer>();
		for (int i=0;i< nums.length;i++){
			if (haveNum.containsKey(target - nums[i])){
				return new int[]{haveNum.get(target-nums[i]),i};
			}
			haveNum.put(nums[i],i);
		}
		return new int[]{1};
	}
}
