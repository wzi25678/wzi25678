package 日常Java程序测试.代码随想录.数组;

public class __69x的平方根__牛顿迭代法 {
	/**
	 *
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		if (x == 0){
			return 0;
		}
		double C = x,x0 = x;
		while (true){
			double x_i = 0.5 * (x0 + C / x0);
			if (Math.abs(x0 - x_i) < 1e-7){
				break;
			}
			x0 = x_i;
		}
		return (int) x0;
	}
}
