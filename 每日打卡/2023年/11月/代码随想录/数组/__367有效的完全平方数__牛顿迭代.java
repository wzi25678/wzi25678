package 日常Java程序测试.代码随想录.数组;

public class __367有效的完全平方数__牛顿迭代 {
	/**
	 *
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		double x0 = num;
		while (true){
			double x1 = (x0 + num / x0) / 2;
			if (x0 - x1 < 1e-6){
				break;
			}
			x0 = x1;
		}
		int x = (int) x0;
		return  x*x == num;
	}
}
