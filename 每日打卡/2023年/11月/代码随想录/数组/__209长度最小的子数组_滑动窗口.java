package 日常Java程序测试.代码随想录.数组;

public class __209长度最小的子数组_滑动窗口 {
	/**
	 *
	 * @param target
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int target, int[] nums) {
		//左边开头，右边为范围，不够就右移增加，够了就左移减少。
		int left = 0,sum = 0;
		int res = Integer.MAX_VALUE;    //要找满足条件的最小长度
		for (int right = 0;right < nums.length;right++){
			sum += nums[right]; //正常右移
			while (sum >= target){
				/** 看似是嵌套关系
				 *  实则，里面的while受到外面的for的限制
				 *  最多移动次数也只有 n + (n-1) 次。
				 */
				//够了，首先就需要记录下当前的长度，因为待会儿还得
				res = Math.min(res,right - left + 1);
				//同时左指针需要向右移动
				sum -= nums[left];
				++left;
			}
		}
		//防止没有找到任何满足条件的情况发生
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
