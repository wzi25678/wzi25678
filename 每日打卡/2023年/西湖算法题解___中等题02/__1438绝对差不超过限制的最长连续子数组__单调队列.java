package 西湖算法题解___中等题02;

import java.util.Deque;
import java.util.LinkedList;

public class __1438绝对差不超过限制的最长连续子数组__单调队列 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @param limit
	 * @return
	 */
	public int longestSubarray(int[] nums, int limit) {
		Deque<Integer> queueMax = new LinkedList<Integer>();       //待会儿可以测一下  ArrayDeque<Integer>();
		Deque<Integer> queueMin = new LinkedList<Integer>();       //待会儿可以测一下  ArrayDeque<Integer>();
		int n = nums.length;
		int left = 0,right = 0;
		int res = 0;
		while (right < n){
			while (!queueMax.isEmpty() && queueMax.peekLast() < nums[right]){
				queueMax.pollLast();
			}
			while (!queueMin.isEmpty() && queueMin.peekLast() > nums[right]){
				queueMin.pollLast();
			}
			queueMax.offerLast(nums[right]);
			queueMin.offerLast(nums[right]);
			while (!queueMax.isEmpty() && !queueMin.isEmpty() && queueMax.peekFirst() - queueMin.peekFirst() > limit){
				if (nums[left] == queueMin.peekFirst()){
					queueMin.pollFirst();
				}
				if (nums[left] == queueMax.peekFirst()){
					queueMax.pollFirst();
				}
				left++;
			}
			res = Math.max(res,right - left + 1);
			right++;
		}
		return res;
	}
}
