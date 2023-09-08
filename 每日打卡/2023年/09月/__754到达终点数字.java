package 西湖算法题解___中等题;

public class __754到达终点数字 {
	//第 i 次移动（从  i == 1 开始，到 i == numMoves ）
	//问，从0走到target需要走最少多少步？
	public int reachNumber(int target) {
		target = Math.abs(target);  //不考虑方向，统一按正方向算
		int k = 0;
		while (target > 0){
			k++;
			target -= k;
		}
		return target % 2 == 0 ? k:k+1+k%2;
	}
}
