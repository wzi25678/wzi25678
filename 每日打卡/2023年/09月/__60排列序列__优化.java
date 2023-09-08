package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class __60排列序列__优化 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param n
	 * @param k
	 * @return
	 */
	private int nums[];
	public String getPermutation(int n, int k){
		Permutations permutations = new Permutations();
		nums = new int[n];
		for (int i=0;i<n;i++){
			nums[i] = i+1;
		}
		List<List<Integer>> result = Collections.singletonList(permutations.permute(String.valueOf(nums)));
		int timeLock = 1;
		for (List<Integer> permutation : result){
			if (timeLock == k){
				return permutation.toString();
			}
			timeLock++;
		}
		return null;
	}

	public class Permutations {
		public List<Integer> permute(String str) {
			List<Integer> result = new ArrayList<>();
			backtrack(str.toString().toCharArray(), 0, result);
			return result;
		}
	}

	/**
	 *
	 * @param arr
	 * @param start
	 * @param result
	 */
	private void backtrack(char[] arr, int start, List<Integer> result ) {
		if (start == arr.length - 1){
			result.add(Integer.valueOf(new String(arr)));
		}else {
			for (int i= start;i< arr.length;i++){
				swap(arr,start,i);
				backtrack(arr,start+1,result);
				swap(arr,i,start);
			}
		}

	}

	/**
	 *
	 * @param nums
	 * @param i
	 * @param j
	 */
	private void swap(char[] nums, int i,int j ){
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
