package 西湖算法题解___简单题;

public class __172阶乘后的零 {
	public static void main(String[] args) {

	}

	//0 <= n <= 10^4
	public int trailingZeroes(int n) {
		int count =  0;
		while (n>0){
			count+=(n/5);
			n/=5;
		}
		return count;
	}
}
