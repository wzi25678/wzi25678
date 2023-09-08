package 西湖算法题解___中等题;

import java.util.HashMap;

public class __454四数相加II {
		public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
			/*
			用key 记录累计求和的值，
			用value 记录当前值的实现次数
			 */
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			int res  = 0;
			//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n
			int n = nums1.length;
			//将四层循环，转化为   【2*两层循环 + Hash】
			//-------------------nums1[i] + nums2[j]----------------------------------------
			for (int i = 0;i<n;i++){
				for (int j = 0;j<n;j++){
					//遍历i、j求和
					int frontSum = nums1[i] + nums2[j];
					if (map.get(frontSum)  == null){    //如果从来没有被加入过
						map.put(frontSum,1);
					}else{
						Integer value = map.get(frontSum);
						map.put(frontSum,value++);
					}
				}
			}
			//------------------------nums3[i] + nums4[j]-----------------------------------
			for (int i = 0;i<n;i++) {
				for (int j = 0; j < n; j++) {
					//遍历i、j求和
					int tailSum = nums3[i] + nums4[j];
					/*
					我们的目标是求和为0，
						那么如果map.get(0- tailSum)存在，说明就有可以满足求和为0的某组情况
					 */
					Integer value = map.get(0 - tailSum);
					if (value != null){
						res+=value;
					}

				}
			}
			return res;
		}
}
