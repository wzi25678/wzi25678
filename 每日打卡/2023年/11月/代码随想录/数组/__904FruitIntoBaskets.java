package 日常Java程序测试.代码随想录.数组;

import java.util.HashMap;
import java.util.Map;

public class __904FruitIntoBaskets {
	/**
	 * 求最长的只包含两种类型的连续子数组的最大长度
	 * @param fruits
	 * @return
	 */
	public int totalFruit(int[] fruits) {   //连续数组 -> 滑动窗口   -> 右边正常移动，左边框定起始边界进行移动.
		int n = fruits.length;
		Map<Integer,Integer> cnt = new HashMap<Integer,Integer>();
		int left = 0,res = 0;
		for (int right = 0;right < n;++right){
			cnt.put(fruits[right],cnt.getOrDefault(fruits[right],0) + 1);
			while (cnt.size() > 2){
				cnt.put(fruits[left],cnt.get(fruits[left]) - 1);
				if (cnt.get(fruits[left]) == 0){
					cnt.remove(fruits[left]);
				}
				++left;
			}
			res = Math.max(res,right - left + 1);
		}
		return res;
	}
}
