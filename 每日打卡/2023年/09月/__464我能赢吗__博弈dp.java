package 西湖算法题解___中等题;

public class __464我能赢吗__博弈dp {
	int maxChoose ,total;
	int dp_canIWin [][] ;
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		dp_canIWin = new int[1 << maxChoosableInteger][2];
		// 1 true  |  -1  false
		maxChoose = maxChoosableInteger;
		if (maxChoosableInteger * (maxChoosableInteger + 1) /2 < desiredTotal){
			return false;
		}
		if (total == 0){
			return true;
		}

		total = desiredTotal;
		return dfs_canIWin(0,0,0) == 1;
	}

	/**
	 *
	 * @param state    状态
	 * @param curTotal  当前总和
	 * @param round     轮数
	 * @return
	 */
	private int dfs_canIWin(int state, int curTotal,int round) {
		if (state == ((1 << maxChoose)-1)  && curTotal <total ){
			return -1;
		}
		if (dp_canIWin[state][round%2] != 0) {
			return dp_canIWin[state][round % 2];
		}
		int hope = round%2 == 0? 1:-1;
		for (int i=0;i<maxChoose;i++){
				if (((state >> i) & 1) == 1){
					continue;
				}
				if (curTotal + i +1 >= total){
					return dp_canIWin[state][round % 2] = hope;
				}
				if (dfs_canIWin(state|(1 << i),curTotal+i+1,round+1) == hope){
					return dp_canIWin[state][round%2] = hope;
				}
		}
		return dp_canIWin[state][round%2] = -hope;
	}
}
