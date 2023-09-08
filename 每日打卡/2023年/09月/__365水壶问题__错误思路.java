package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __365水壶问题__错误思路 {
	//AC   15/28
	/**
	 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
	 */
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		int remind1 =0,remind2 = 0;
		if (jug1Capacity>=jug2Capacity){
			remind1 = jug1Capacity-jug2Capacity;
			if (jug2Capacity>=remind1){
				remind2 = jug2Capacity-remind1;
			}else {
				remind2 = remind1 -jug2Capacity;
			}
		}else{
			remind1 = jug2Capacity-jug1Capacity;
			if (jug1Capacity >= remind1){
				remind1 = jug1Capacity  -remind1;
			}else{
				remind1 = remind1 - jug2Capacity;
			}
		}
		int nums[] = new int[]{jug1Capacity,jug2Capacity,remind1,remind2};

		List<Integer> resultList = new ArrayList<>();
		// 进行任意两个数的+或者-运算
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					resultList.add(nums[i] + nums[j]);
					resultList.add(nums[i] - nums[j]);
				}
			}
		}
		for (int num:resultList){
			if (num == targetCapacity){
				return true;
			}
		}
		return false;
	}
}
