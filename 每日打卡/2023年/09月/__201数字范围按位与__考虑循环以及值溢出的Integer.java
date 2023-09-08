package 西湖算法题解___中等题;

public class __201数字范围按位与__考虑循环以及值溢出的Integer {
	public int rangeBitwiseAnd(int left, int right) {
		/**
		 * 如果等于Integer.MAX_VALUE了，那么在计算机中则会因为补码，而实现从负数再来一遍，但在数字中则不会
		 * 相反，会直接溢出掉。
		 */

		if (left == Integer.MAX_VALUE){
			return left;
		}
		int res = left;
		for (int i=left+1;i<=right;i++){
			res &=i;
			if (res == 0 || i== Integer.MAX_VALUE){
				break;
			}
		}
		return res;
	}
}
