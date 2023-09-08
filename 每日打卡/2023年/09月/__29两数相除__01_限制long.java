package 西湖算法题解___中等题;

public class __29两数相除__01_限制long {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor){
		//同一个类型中，负数可以表示的要比正数多一个，即更大
		int MIN = Integer.MIN_VALUE,MAX = Integer.MAX_VALUE;
		int a = dividend,b = divisor;
		int LIMIT = -1073741824;
		if (dividend == MIN && divisor == -1){
			return MAX;
		}
		boolean flag = false;
		if (((dividend >0) && (divisor<0)) || (dividend<0 && divisor>0) ){
			flag = true;
		}
		if (a>0) {
			a = -a;
		}
		if (b > 0){
			b = -b;
		}
		int ans = 0;
		while (a <=b){
			int c = b,d =-1;
			while (c>=LIMIT && d >= LIMIT && c >= a-c){
				c+=c;
				d+=d;
			}
			a -= c;
			ans+=d;
		}
		return flag?ans:-ans;
	}
}
