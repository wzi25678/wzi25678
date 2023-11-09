package 日常Java程序测试.代码随想录.滑动窗口;

public class __209长度最小的子数组 {
	/**
	 *
	 * @param target
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int target, int[] nums) {
		//通过滑动窗口找连续子数组/子串的长度
		//不够就右移，<    够了>= 就左移，同时做记录
		int left = 0,sum = 0;
		int res = Integer.MAX_VALUE;    //因为要找最小
		for (int right = 0;right < nums.length;right++){
			sum += nums[right];
			//内层一个循环去判断长度够不够，够了就移动，不够就继续加
			while (sum >= target){
				//先记录，再移动
				res = Math.min(res,right - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 :res;
	}

}
