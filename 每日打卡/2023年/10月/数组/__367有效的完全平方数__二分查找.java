package 日常Java程序测试.代码随想录.数组;

public class __367有效的完全平方数__二分查找 {
	/**
	 *
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		int left = 0,right = num;
		while (left <= right){
			int mid = (right - left) /2 + left;
			long square = (long)mid * mid;
			if (square < num){
				left = mid + 1;
			} else if (square > num) {
				right = mid - 1;
			}else {
				return true;
			}
		}
		return false;
	}
}
