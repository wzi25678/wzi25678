package 西湖算法题解___简单题;

import java.util.HashMap;
import java.util.Map;

public class __219存在重复元素II__Hash法 {
	public static void main(String[] args) {

	}

	public static  boolean containsNearbyDuplicate(int[] nums, int k){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i=0;i< nums.length;i++){
			int num = nums[i];
			if (map.containsKey(num) && Math.abs(i-map.get(num) )<= k){
				return true;
			}
			//如果不包含，则保存进map中
			map.put(num,i);
		}
		return false;
	}
}