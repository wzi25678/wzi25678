package 西湖算法题解___中等题;

import java.util.*;

public class __380__O1时间插入删除和获取随机元素__深入理解 {
	class RandomizedSet {
		List<Integer> nums;
		Map<Integer,Integer>  indices;
		Random random;

		public RandomizedSet() {
			nums = new ArrayList<Integer>();
			indices= new HashMap<Integer,Integer>();
			random= new Random();
		}

		public boolean insert(int val) {
			if (indices.containsKey(val)){
				return false;
			}
			//得有index去记录数组位置，同时又得有Map去 保存对应的（key，value）则可以达到O（1）
			int index = nums.size();
			nums.add(val);
			indices.put(val,index);
			return true;
		}

		public boolean remove(int val) {
			if (!indices.containsKey(val)){
				return false;
			}
			int  index = indices.get(val);
			int last = nums.get(nums.size() - 1);
			nums.set(index,last);   //两处（value）互换一下
			indices.put(last,index);
			nums.remove(nums.size()-1); //删除最后一个位置
			indices.remove(val);    //Map里也删掉val这个key
			return true;
		}

		public int getRandom() {
			int randomIndex = random.nextInt(nums.size());  //生成一个Int类型的[0,nums.size)这个范围内的一个随机数。
			return nums.get(randomIndex);
		}
	}

}
