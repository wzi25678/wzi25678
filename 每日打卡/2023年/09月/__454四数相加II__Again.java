package 西湖算法题解___中等题;

import java.util.HashMap;

public class __454四数相加II__Again {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		HashMap<Integer,Integer>  map = new HashMap<Integer,Integer>();
		int res = 0;
		int n = nums1.length;
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				int frontSum = nums1[i] + nums2[j];
				if (map.get(frontSum) == null){
					map.put(frontSum,1);
				}else{
					Integer value = map.get(frontSum);
					map.put(frontSum,value+1);
				}
			}
		}
		//----------------------------------------------------------------------------
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				int tailSum = nums3[i] + nums4[j];
				//求和之后，应该去判断是否会等于-frontSum
				//这里遍历到的每一个情况，都得去加上第一次for循环得到的累计（value）和。
				if (map.get(-tailSum) != null){
					Integer value = map.get(-tailSum);
					res+=value;
				}
			}
		}
		return res;
	}
}
