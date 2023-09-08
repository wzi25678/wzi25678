package 西湖算法题解___中等题;

public class __29两数相除 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE){
			if (divisor == -1){
				return Integer.MAX_VALUE;
			}
		}
		//考虑除数为最小值的情况
		if (divisor== Integer.MIN_VALUE){
			return dividend == Integer.MIN_VALUE ? 1:0;
		}

		//考虑被除数为0的 情况
		if (dividend  == 0){
			return 0;
		}

		//一般情况下，使用二分查找
		//将所有的 整数取相反数，这样就只需要考虑一种情况
		boolean rev = false;
		if (dividend > 0){
			dividend = -dividend;
			rev =!rev;
		}
		if (divisor > 0){
			divisor = -divisor;
			rev = !rev;
		}

		int left =1,right = Integer.MAX_VALUE,ans = 0;
		while (left <=right){
			//注意溢出，并且不能使用除法
			int mid = left + ((right - left ) >>1);
			boolean check = quickAdd(divisor,mid,dividend);
			if (check){
				ans = mid;
				//注意溢出
				if (mid == Integer.MAX_VALUE){
					break;
				}
				left = mid +1;
			}else {
				right = mid-1;
			}
		}
		return rev ? -ans:ans;
	}

	/**
	 *
	 * @param y
	 * @param z
	 * @param x
	 * @return
	 */
	private boolean quickAdd(int y, int z, int x) {
		int result = 0,add = y;
		while ( z != 0){
			if((z & 1) != 0){
				if(result < x -add){
					return  false;
				}
				result += add;
			}
			z >>= 1;
		}
		return  true;
	}
}
