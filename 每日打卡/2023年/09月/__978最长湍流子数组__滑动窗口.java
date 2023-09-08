package 西湖算法题解___中等题;

public class __978最长湍流子数组__滑动窗口 {
	//滑动窗口的思路，就是一直不断向外扩张，进行判断
	/**
	 题目解释：
	    即遍历找满足条件的最长连续子数组

	 * @param arr
	 * @return
	 */
	public int maxTurbulenceSize(int[] arr) {
		//1 <= arr.length <= 4 * 104
		//0 <= arr[i] <= 109
		if (arr.length <1){
			return 0;
		}
		int res = 1;
		int left = 0,right = 0;
		while (right < arr.length-1){
			if (left == right){
				if (arr[left] == arr[left + 1]){    //来看left，right是否应该移动
					left++;
				}
				right++;
			}else {
				if (arr[right - 1] < arr[right] && arr[right] > arr[right+1]){
					right++;
				}else if (arr[right - 1] > arr[right] && arr[right] < arr[right+1]){
					right++;
				}else {
					left = right;
				}
			}
			res = Math.max(res,right - left + 1);
		}
		return res;
	}
}
