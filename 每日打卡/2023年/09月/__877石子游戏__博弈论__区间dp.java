package 西湖算法题解___中等题;

public class __877石子游戏__博弈论__区间dp {
	/**
	 Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子,,,每堆都有 正 整数颗石子，数目为 piles[i] 。
	 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。

	 偶数堆石子，总数一定为奇数。

	 Alice 和 Bob 轮流进行，Alice 先开始。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。
	 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。


	 * @param piles
	 * @return
	 */
	public boolean stoneGame(int[] piles) {
		int dp_stoneGame [][] = new int[piles.length][piles.length];
		for (int i=0;i< piles.length;i++){
			dp_stoneGame[i][i] = piles[i];
		}
		for (int i=piles.length-2;i>=0;i--){
			for (int j=i+1;j< piles.length;j++){
				dp_stoneGame[i][j] = Math.max(piles[i] - dp_stoneGame[i+1][j],piles[j]-dp_stoneGame[i][j-1]);
			}
		}
		return dp_stoneGame[0][piles.length-1] > 0;
	}
}
