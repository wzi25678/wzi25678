package 日常Java程序测试.代码随想录.数组;

public class __367有效的完全平方数__使用内置的库函数 {
	/**
	 *
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		//判断一个数是不是整数的平方
		int x = (int)Math.sqrt(num);
		return x*x == num;
	}
}
