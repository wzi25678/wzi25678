package 西湖算法题解___中等题;

import java.util.Arrays;

public class __416分割等和子集 {
	/*
	给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
	  ->  意思就是一个数组，能否切成两个部分，然后这两个部分和相等

	思路：
		两个部分相等，则就说明需要有一个部分，能等于所有数字总和的一半         ->统计所有数字总和
		那么我可以sort，然后把值都加进去，看是不是会等于一半，等于则return true
									不等于的话，如果是多了，则去掉与差额大一个的。
		全部遍历完，还是没有结果的话，则return false;
	 */
	public boolean canPartition(int[] nums) {
		int total_half = 0;
		for (int num:nums){
			total_half+=num;
		}
		total_half/=2;
		Arrays.sort(nums);
		int n = nums.length;
		int cnt = 0;
		for (int i=0;i< n;i++){
			cnt+=nums[i];
			if (cnt == total_half){
				return false;
			} else if (cnt > total_half) {
				int remind = cnt-total_half;
				//这样耿直的话，那你还需要标记哪些数组 是你用过的，哪些是你没用过的 。
/*				  错误方法，看来是。我搞，更复杂了，这么搞。
				  同时还说明，你还需要一个标记位，看是不是被使用过
				  ->  采用dp.
			for (){

				}

				*/
			}else { //  cnt < total_half
				//则不用管，继续往里面加入值即可。
			}
		}
		return false;
	}
}
