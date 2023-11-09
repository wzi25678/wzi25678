package 日常Java程序测试.代码随想录.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class __904水果成篮 {
	/**
	 *
	 * @param fruits
	 * @return
	 */
	public int totalFruit(int[] fruits) {
		//也是连续子数组，但只能容纳两种类型
		//hashmap是一种键值无序的哈希映射
		int n = fruits.length;
		Map<Integer,Integer> count = new HashMap<Integer,Integer>();
		int left = 0,res = 0;
		for (int right = 0;right < n;++right){
			//  key: fruits[right]   value:  getOrDefault(fruits[right],0)+1
			count.put(fruits[right],count.getOrDefault(fruits[right],0)+1);
			//放完当前位置，去判断目前放了多少个
			while (count.size() > 2){
				//如果目前大于两个，则删除
				count.put(fruits[left],count.get(fruits[left]) - 1);    //删掉目前最左边
				if (count.get(fruits[left]) == 0){
					count.remove(fruits[left]);
				}
				++left;
			}
			res = Math.max(res,right - left + 1);
		}
		return res;
	}
}
