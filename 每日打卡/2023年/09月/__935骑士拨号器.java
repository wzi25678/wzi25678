package 西湖算法题解___中等题;

import java.util.Arrays;

public class __935骑士拨号器 {
	/**
	 题目要求：
	    键盘上的数字，随便选择
	    输入，代表你要返回的长度

	    然后走法只能走L行。
	 * @param n
	 * @return
	 */
	public int knightDialer(int n) {
		//dp    ->      方法一：动态规划
		//所以输出答案模 109 + 7.
		int mod = 1000000007;
		int [][] moves = new int[][]{
				{4,6},{6,8},{7,9},{4,8},{3,9,0},
				{},{1,7,0},{2,6},{1,3},{2,4}
		};
		int dp_knightDialer [][] = new int[2][10];
		Arrays.fill(dp_knightDialer[0],1);
		for (int hops = 0;hops <n-1;hops++){
			Arrays.fill(dp_knightDialer[~hops & 1],0);
			for (int node = 0;node < 10;node++){
				for (int state:moves[node]){
					dp_knightDialer[~hops & 1][state] += dp_knightDialer[hops & 1][node];
					dp_knightDialer[~hops & 1][state] %= mod;
				}
			}

		}
		long res = 0;
		for (int x :dp_knightDialer[~n & 1]){
			res += x;
		}
		return (int)(res % mod);
	}
}
