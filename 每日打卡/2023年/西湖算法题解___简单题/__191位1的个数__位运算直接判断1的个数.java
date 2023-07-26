package 西湖算法题解___简单题;

public class __191位1的个数__位运算直接判断1的个数 {
	public static void main(String[] args) {

	}
	public int hammingWeight(int n){
		int res=0;
		for (int i=0;i<32;i++){
			if ((n&(1<<i)) !=0){
				/*
				一个1一直向左移一位，那么就是一直000000100000000000这样
				，就用这一个唯一的1去和n与，如果n有某位与之对应的位，不是0，而是1，则   与&  出来的结果就是1，
				从而判断出了1的个数。
				 */
				res++;
			}
		}
		return res;
	}
}
