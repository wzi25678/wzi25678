package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

public class __454四数相加II {
	/**
	 * 没有时间限制，要在四个数组里面每个数组里挑一个元素，让他们的和等于0
	 * 那么引用前面的集合类型，就可以暴力的求解
	 * 就是逐个元素加入到集合中，构成一个大集合
	 * 看最后的所有元素之和，能不能实现等于0
	 *
	 * @param nums1
	 * @param nums2
	 * @param nums3
	 * @param nums4
	 * @return
	 */
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		//key代表当前和     value代表该值的实现次数
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int res = 0;
		int n = nums1.length; //给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n
		for (int i=0;i<n;i++){
			for (int j = 0;j<n;j++){
				int curSum = nums1[i] +nums2[j] ;
				//求完和，就得加入到HashMap中
				//检测当前遍历求和结果是否加入到HashMap中
				if (!map.containsKey(curSum)){  //如果没有包含当前key
					map.put(curSum,1);  //记录1次
				}else{  //包含当前key
					//map.getOrDefault(curSum,1); //返回的是一个value对象
					//我不是要获取它的value值，而是要给他的value++
					Integer value = map.get(curSum);
					map.put(curSum,++value);
				}
			}
		}
		//-------------------------------------------------------------------------------
		//可以模仿参考答案，再构造另外两个集合的HashMap结构，也可以一个一个单独加入原先结构
		//貌似三个数反而不好搞，因为你如果有第四个数还，你想单纯地把第三个数再放进集合中，貌似有点困难
		//这里还是得四个数，两两一组去操作比较好
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				int curSum =  nums3[i] +nums4[j];
				if (map.get(-curSum) != null){
					Integer value = map.get(-curSum);
					res+=value;
				}
			}
		}
		return res;
//		//----------------
//		for (int i=0;i<n;i++){
//
//		}
		//集合这种东西，只能全集去对部分集，不能全集中去判别，部分的部分集这种操作。
	}
}
