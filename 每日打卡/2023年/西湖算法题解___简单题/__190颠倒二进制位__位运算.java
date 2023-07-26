package 西湖算法题解___简单题;

public class __190颠倒二进制位__位运算 {
	public static void main(String[] args) {

	}

	public int reverseBits(int n){
		int res = 0;
		for (int i=0;i<32; i++){
			res = res | (n&1) <<(32-i);
			n>>=1;
		}
		return res;
	}
}
