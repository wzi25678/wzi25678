package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class __349两个数组的交集__去重找交集 {
	/**
	 * 用两个Set集合，去重，然后找出去重后的重叠部分。
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		//去重先
		for (int num : nums1){
			set1.add(num);
		}
		for (int num : nums2){
			set2.add(num);
		}
		return getIntersection(set1,set2);
	}

	private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		//保证set1是短的，set2是长的
		if (set1.size() > set2.size()){
			return getIntersection(set2,set1);
		}
		//构造一个交集集合
		Set<Integer> intersectionSet = new HashSet<Integer>();
		for (int num : set1) {
			if (set2.contains(num)){
				intersectionSet.add(num);
			}
		}
		//集合转数组
		int res[] = new int[intersectionSet.size()];
		int index = 0;
		for (int num:intersectionSet){
			res[index++] = num;
		}
		return res;
	}
}
