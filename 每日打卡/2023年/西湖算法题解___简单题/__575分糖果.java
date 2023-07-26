package 西湖算法题解___简单题;

import java.util.Arrays;

public class __575分糖果 {
	public static void main(String[] args) {

	}

	public int distributeCandies(int[] candyType) {
		int CandyNumbers = 0;
//		for (int nums : candyType) {
//			CandyNumbers+=nums;
//		}
//		CandyNumbers/=2;
		CandyNumbers=candyType.length;
		CandyNumbers/=2;
		Arrays.sort(candyType);
		if (candyType.length ==0){
			return 0;
		}
		int res = 1;
		for (int i=1;i<candyType.length;i++){
			if (candyType[i] != candyType[i-1] ){
				//说明不是同一种蛋糕
				if (res < CandyNumbers){
					res++;
				}
			}
			//说明是同一种蛋糕,则不进行操作
		}
		return res;


	}
}
