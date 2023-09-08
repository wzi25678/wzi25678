package 西湖算法题解___中等题;

import java.util.Arrays;

public class __464我能赢吗__博弈dp__评论区大佬__高性能 {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		//累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
		//两个人共用一个累积和
		/**
		 这是一道博弈论 DP 的题，为了方便，我们使用 n 来表示 maxChoosableInteger，使用 t来表示 desiredTotal。
		 由于 n 数据范围为 20，且每个数只能选一次，我们可以使用一个二进制数 state 来表示 [1,n]范围内的被选择的数的情况：二进制表示中 1的位置代表数已被选择，否则代表尚未选择。
		 首先朴素二维状态表示相对容易想到：定义 f[statue][k] 为当前已被选择的数为 state，轮数为k时，「原始回合的先手」能否获胜（1代表能，−1代表不能），其中 k从 0开始，通过 k的奇偶性可知是原始回合的先手还是后手。
		 设计递归函数来实现「记忆化搜索」，函数 int dfs(int state, int tot, int k) 表示当前状态为 state，tot对应累计和，k代表轮数，最终答案通过判断 dfs(0, 0, 0) 是否为 1 来得知。

		 转移过程中，如果发现当前回合的决策，能够直接使得累积和超过 t，说明当前回合玩家获胜；或者如果当前决策能够导致下一回合的玩家失败的话，当前回合玩家也获胜，否则当前玩家失败。
		 */
		if (maxChoosableInteger * (maxChoosableInteger + 1) /2 < desiredTotal){
			return false;
		}
		int [] dp_canIWin = new int[1<<maxChoosableInteger];
		Arrays.fill(dp_canIWin,-1); // 1 true   ---  -1 false
		//默认给个false
		return dfs_canIWin(desiredTotal,0,maxChoosableInteger,dp_canIWin) == 1 ;
	}

	/**
	 *
	 * @param totalCount      累计和
	 * @param state     当前累计情况
	 * @param maxChoose   整数池中可选择的最大数
	 * @param dp_canIWin    判断数组
	 * @return
	 */
	private int dfs_canIWin(int totalCount, int state, int maxChoose, int[] dp_canIWin) {
		if (dp_canIWin[state] != -1){
			return dp_canIWin[state];
		}
		for (int i = 0;i<maxChoose;i++){
			if (((state >> i) & 1) == 1){
				continue;
			}
			if (totalCount <= i + 1){
				return dp_canIWin[state] = 1;   //如果此时有数大于需要的和，则取该数获得必胜
			}
			//如果对手出现必败的状态，则将必败的状态留给对手
			if (dfs_canIWin(totalCount -i-1 ,state|(1 << i),maxChoose,dp_canIWin) == 0){
				return dp_canIWin[state] = 1;
			}
		}
		return dp_canIWin[state] = 0;
	}
}
