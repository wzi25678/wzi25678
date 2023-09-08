package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.Deque;

public class __454是否有132模式__单调栈 {
	public boolean find132pattern(int[] nums) {
		/**
		 解题思路：
		    i<j<k
		 arr[i]<arr[k]<arr[j]
		 这个得自己动一下脑子，可以推算出，从k开始找arr[i]、arr[j]效果会更好。      ->则我们应该从数组尾部开始遍历

		 优化：即两个元素，通过一个判断去移动，降低为O(n^2)
		 如上，我们先去找j出来，即arr[j]大于arr[k]的。
		    这是会有如下情况，接下来的元素：
		        1.比arr[k]小
		            return ture;
		        2.比arr[k]大，但比arr[j]小        我们管这个叫arr[temp]    temp<j
		            不用管
		        3.比arr[j]大       我们管这个叫arr[temp]    temp<j
		            我们使arr[k] = arr[j]
		            arr[j]  = arr[temp]
		 */
		int nLength = nums.length;
		if (nLength < 3){
			return false;
		}
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int temp = Integer.MIN_VALUE;
		for (int i = nLength-1;i>=0;i--){
			if (nums[i] < temp){
				return true;
			}
			while (!stack.isEmpty() && nums[i] > stack.peek()){
				temp = stack.pop();
			}
			stack.push(nums[i]);
		}
		return false;
	}
}
