package 日常Java程序测试.代码随想录.数组;

public class __69x的平方根__二分查找 {
	/**
	 *
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		int left = 0,right = x,res = -1;
		while (left <= right){
			int mid = left + (right - left) / 2;
			if ((long)mid * mid <= x){
				res = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return res;
	}
}
