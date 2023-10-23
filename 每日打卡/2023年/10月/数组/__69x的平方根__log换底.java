package 日常Java程序测试.代码随想录.数组;

public class __69x的平方根__log换底 {
	/**
	 *
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		//结果只保留 整数部分 ，小数部分将被 舍去 。
		if(x == 0){
			return 0;
		}
		int res = (int) Math.exp(0.5 * Math.log(x));
		return (long)(res + 1) * (res + 1) <= x ? res + 1 :res;
	}
}
