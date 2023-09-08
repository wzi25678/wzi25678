package 西湖算法题解___中等题;

import java.util.HashMap;
import java.util.Map;

public class __525连续数组 {
	public int findMaxLength(int[] nums) {
		//连续0/1数组
		int maxLength = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int counter = 0;
		map.put(counter,-1);
		int n = nums.length;
		for (int i=0;i<n;i++){
			int num = nums[i];
			if (num == 1){
				counter++;
			}else {
				counter--;
			}
			if (map.containsKey(counter)){
				int prevIndex = map.get(counter);
				maxLength = Math.max(maxLength,i-prevIndex);
			}else {
				map.put(counter,i);
			}
		}
		return maxLength;
	}
}
