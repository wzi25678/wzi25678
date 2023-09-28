package 西湖算法题解___中等题02;

public class __1015可被K整除的最小整数 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
		//求满足条件的最少的1的个数
		//大数，String，转，去实现？

	}
	/**
	 //给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
	 //求满足条件的最少的1的个数
	 //大数，String，转，去实现？
	 */

	public int smallestRepunitDivByK(int k) {
		if (k%2==0){
			return -1;
		}
		int sum = 0;
		for (int i=1;i<=k;i++){
			//为什么最大就是k呢？很简单，k个1一定可以被k整除
			sum=(sum*10 + 1)%k;
			if (sum==0){
				return i;
			}
		}
		return -1;

	}
}
