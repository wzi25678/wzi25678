package 西湖算法题解___简单题;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
	public static void main(String[] args) {
		int nums[] = {3,2,4};
		int target = 6;
		towSum(nums,target);


	}

	private static int[] towSum(int[] nums, int target) {
		Map<Integer,Integer> hashmap = new HashMap<>();
		for (int i=0;i< nums.length;i++){
			if (hashmap.containsKey(target-nums[i])){
				System.out.println(nums[i]+" "+i);
				return new int[]{hashmap.get(target - nums[i]), i};
			}
			System.out.println("没事      "+nums[i]+" "+i);
			hashmap.put(nums[i],i);

		}
		return new int[0];

	}


	private   static  int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> hashmap = new HashMap<>();
		for (int i=0;i< nums.length;i++){
			if (hashmap.containsKey(target-nums[i])){
				return new int[]{hashmap.get(target - nums[i]), i};
			}
			hashmap.put(nums[i],i);
		}
		return new int[0];

	}
}
