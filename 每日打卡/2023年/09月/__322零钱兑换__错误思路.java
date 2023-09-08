package 西湖算法题解___中等题;

import java.util.Arrays;

public class __322零钱兑换__错误思路 {
	public static void main(String[] args) {
		int coins[] = {186,419,83,408};
		int amount = 6249;
		System.out.println(coinChange(coins,amount));
	}
	public static int coinChange(int[] coins, int amount) {
		/*
		解题思路：
			1.先sort一下coins确保硬币面值是从小到大排序的
			2.从最大面额的硬币开始，到最小面额的硬币来结束程序 -> for（）
			3.每次面额从1开始，往最多可以选择的能力去++


			这会导致一个很大的问题，那就是原本可以找的开的零钱，会因为你上述的操作，导致根本找不开，因为不存在最低基本单位1
		 */
		Arrays.sort(coins);
		int useNums = 0;
		//先过滤掉一些没用的
			//如果总金额小于最小的硬币面值
		if (amount==0){
			return 0;
		}
		int coins_length = coins.length -1;
		for (int i=coins_length;i>=0;i--){
			//所有硬币的面值
			for (int j=1;j<=amount/coins[i]+1;j++){
				if (amount - coins[i]*j >0){
					//继续
					useNums++;
				} else if (amount - coins[i]*j ==0) {
					useNums++;
					return useNums;
				}else{
					//说明当前面值换不了了
					amount-=(coins[i]*(j-1));
					break;
				}
			}
		}
		return -1;
	}
}
