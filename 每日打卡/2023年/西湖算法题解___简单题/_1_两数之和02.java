package 西湖算法题解___简单题;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和02 {



	private static int[] towSum(int[] nums, int target){
		int res [] = new int[2];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			int temp = target - nums[i];
			if(map.containsKey(temp)){
				res[1] = i;
				res[0] = map.get(temp);
				return res;
			}
			map.put(nums[i],i);
		}
		return res;

	}
}
