package 西湖算法题解___中等题02;

import java.util.HashMap;
import java.util.Map;

public class __1218最长定差子序列 {
	/**


	 *
	 * @param arr
	 * @param difference
	 * @return
	 */
	public int longestSubsequence(int[] arr, int difference) {
		//dp问题
		int ans = 0;
		Map<Integer,Integer>  dp_longestSubsequence = new HashMap<Integer,Integer>();
		for (int v : arr){
			dp_longestSubsequence.put(v,dp_longestSubsequence.getOrDefault(v - difference,0) +1);   //每一个顺序子串，我都用一个HashMap去存储，遇到符合顺序递减的，我就给它的key++;
			ans = Math.max(ans,dp_longestSubsequence.get(v));
		}
		return ans;
	}
}
