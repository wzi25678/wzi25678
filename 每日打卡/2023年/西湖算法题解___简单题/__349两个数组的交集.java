package 西湖算法题解___简单题;

import java.util.HashSet;
import java.util.Set;

public class __349两个数组的交集 {
	public static void main(String[] args) {

	}

	/**
	 * 我们以nums1来作为判断数组
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		//先对nums1，nums2去重
		for (int num :nums1){
			set1.add(num);
		}
		for (int num :nums2){
			set2.add(num);
		}
		return getIntersection(set1,set2);
	}

	private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> intersectionSet = new HashSet<Integer>();
		for (int num:set1){
			if (set2.contains(num)){
				intersectionSet.add(num);
			}
		}
		//上面得到的是一个集合，结果就跟链表一样，然后我要把它转化成数组
		int ans [] = new int[intersectionSet.size()];
		int index =0;
		for (int num :intersectionSet){
			ans[index] = num;
			index++;
		}
		return ans;
	}
}
