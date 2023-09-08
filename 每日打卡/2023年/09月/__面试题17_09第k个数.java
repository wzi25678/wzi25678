package 西湖算法题解___中等题;

public class __面试题17_09第k个数 {
	public static void main(String[] args) {
		/**
		 我来解读一下吧，力扣又是一道不说人话的题，
		 就是说，一个数，他只能由3，5，7的乘法运算得到(1是例外)，让你按从小到大顺序求出第k个数是多少。
		 所以思路呼之欲出，先是1*3 1*5 1*7 再是 3*3 3*5 3*7 然后5*3 5*5 5*7
		 反正怎么写都可以，组合写法，动态规划，注意大小顺序以及重复，我的coding之魂已经烧起来了！！！！！！
		 */
	}

	public int getKthMagicNumber(int k) {
		int [] uglyNumbers = new int[k];
		uglyNumbers[0] = 1;
		int index_3 = 0,index_5 = 0,index_7=0;
		int factor_3 = 3,factor_5 = 5,factor_7 = 7;
		for (int i=1;i<k;i++){
			int min= Math.min(Math.min(factor_3,factor_5),factor_7);
			uglyNumbers[i] = min;

			if (min == factor_3){
				index_3++;
				factor_3 = uglyNumbers[index_3]*3;
			}
			if (min == factor_5){
				index_5++;
				factor_5 = uglyNumbers[index_5]*5;
			}
			if (min == factor_7){
				index_7++;
				factor_7 = uglyNumbers[index_7]*7;
			}

		}

		return uglyNumbers[k-1];
	}

}
