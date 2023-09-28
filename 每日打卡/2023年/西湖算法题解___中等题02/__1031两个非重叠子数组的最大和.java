package 西湖算法题解___中等题02;

public class __1031两个非重叠子数组的最大和 {
	/**
	 题目解释：
	    nums[]代表数组
	    int firstLen, int secondLen 代表两个你想要的连续子数组的长度
	    返回最大的和，不能重叠。

	 1 <= firstLen, secondLen <= 1000
	 2 <= firstLen + secondLen <= 1000

	 解题思路：
	    先找短的数组序列，再找长的数组序列。
	 * @param nums
	 * @param firstLen
	 * @param secondLen
	 * @return
	 */
	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
//		int shortLen = Math.min(firstLen,secondLen);
//		int longLen = Math.max(firstLen,secondLen);
//		int n = nums.length;
//		//双重for循环，去找shortLen
//		//再双重for循环去找longLen，并且不能接触到连续的shortLen区间。
		int n = nums.length;
		int sumPrefix [] = new int[n+1];
		for (int i=0;i<n;i++){
			sumPrefix[i+1] = sumPrefix[i] + nums[i];    //计算nums的前缀和
		}
		return Math.max(findEnum(sumPrefix,firstLen,secondLen),findEnum(sumPrefix,secondLen,firstLen));
	}

	private int findEnum(int[] sumPrefix, int firstLen, int secondLen) {
		int maxSumA = 0,ans = 0;
		for (int i=firstLen + secondLen;i<sumPrefix.length;i++){
			maxSumA = Math.max(maxSumA,sumPrefix[i - secondLen] - sumPrefix[i-secondLen-firstLen]);
			ans = Math.max(ans,maxSumA+sumPrefix[i]-sumPrefix[i-secondLen]);
		}
		return ans;
	}
}
