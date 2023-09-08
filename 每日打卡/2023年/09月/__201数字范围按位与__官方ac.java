package 西湖算法题解___中等题;

public class __201数字范围按位与__官方ac {
	public int rangeBitwiseAnd(int left, int right){
		int res = 0;
		while (left < right) {
			left>>=1;
			right>>=1;
			res++;
		}
		return left<<res;
	}
}
