package 西湖算法题解___中等题;

public class __29两数相除__01_不限制long {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *被除数 dividend 和除数 divisor
	 *
	 * @param dividend  被除数
	 * @param divisor   除数
	 * @return
	 *
	 * 要求 不使用 乘法、除法和取余运算。
	 */
	private static int INF = Integer.MAX_VALUE;
	public int divide(int dividend, int divisor) {
		long a = dividend,b = divisor;
		boolean flag = false;
		if ((a < 0 && b > 0)   || (a  > 0  && b < 0)){
			flag  = true;
		}
		if (a<0) {
			a = -a;
		}
		if (b < 0){
			b = -b;
		}
		long left = 0,right = a;
		while (left < right){
			long mid = left+right+1 >> 1;
			if (quickAdd(mid,b) <= a){
				left = mid;
			}else {
				right = mid -1;
			}
		}
		right = flag ? -right :right;
		if (right > INF || right<-INF-1){
			return INF;
		}
		return (int)right;
	}

	/**
	 *
	 * @param a
	 * @param k
	 * @return
	 */
	private long quickAdd(long a, long k) {
		long ans = 0;
		while (k>0){
			if ((k & 1) == 1){
				ans+=a;
			}
			k >>=1;
			a+=a;
		}
		return ans;
	}
}
