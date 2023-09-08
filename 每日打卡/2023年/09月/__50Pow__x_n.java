package 西湖算法题解___中等题;

public class __50Pow__x_n {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		return n >= 0? quickMul(x,n) : 1.0/quickMul(x,-n);
	}

	/**
	 *
	 * @param x
	 * @param n
	 * @return
	 */
	private double quickMul(double x, long n) {
		if (n == 0){
			return 1.0;
		}
		double y = quickMul(x,n/2);
		return n%2 == 0? y*y:y*y*x;
	}
}
