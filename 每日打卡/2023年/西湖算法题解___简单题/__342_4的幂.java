package 西湖算法题解___简单题;

public class __342_4的幂 {
	public static void main(String[] args) {

	}

	public boolean isPowerOfFour(int n) {
		//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
		if (n==1){
			return true;
		}
		if (n<=0){
			return false;
		}
		while (n%4==0){
				  n/=4;
		}
		return n==1;
	}
}
