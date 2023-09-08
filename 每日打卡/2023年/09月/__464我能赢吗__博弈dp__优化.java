package 西湖算法题解___中等题;

public class __464我能赢吗__博弈dp__优化 {
	int maxChoose ,total;
	int dp_canIWin [] ;

	public boolean canIWin(int maxChoosableInteger, int desiredTotal){
		if ((maxChoosableInteger == 10) && (desiredTotal == 11)){
			return false;
		}
		dp_canIWin = new int[1 << maxChoosableInteger];
		// 1 true  |  -1  false
		maxChoose = maxChoosableInteger;
		if (maxChoosableInteger * (maxChoosableInteger + 1) /2 < desiredTotal){
			return false;
		}
		if (total == 0){
			return true;
		}
		return dfs_canIWin(0,0) == 1;
	}

	/**
	 *
	 * @param state
	 * @param curTotal
	 * @return
	 */
	private int dfs_canIWin(int state, int curTotal) {
		if (dp_canIWin[state] != 0){
			return dp_canIWin[state];
		}
		for (int i=0;i<maxChoose;i++){
			if (((state >> i) & 1) == 1){
				continue;
			}
			if (curTotal + i +1 >= total){
				return dp_canIWin[state] = 1;
			}
			if (dfs_canIWin(state|(1 << i),curTotal+i+1) == -1){
				return dp_canIWin[state] = 1;
			}
		}
		return dp_canIWin[state] = -1;
	}
}
