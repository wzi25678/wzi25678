package 日常Java程序测试.代码随想录.数组;

public class __367有效的完全平方数__暴力遍历 {
	/**
	 *
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		long x = 1,square = 1;
		while (square <= num){
			if (square == num){
				return true;
			}
			++x;
			square = x*x;
		}
		return false;
	}
}
