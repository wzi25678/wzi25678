package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __60排列序列__通用超时写法 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param n
	 * @param k
	 * @return
	 */

	private int nums[];

	/**
	 *
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		//按大小顺序列出所有排列情况,    给定n和k，返回第k个排列。
		Permutations permutations = new Permutations();
		nums = new int[n];
		for (int i=0;i<n;i++){
			nums[i] = i+1;
		}
		List<List<Integer>> result = permutations.permute();
		int timeLock = 1;
		for (List<Integer> permutation : result) {
			if (k == timeLock){
				String res = permutation.toString().replaceAll(",","");
				res = res.replaceAll("\\s", "");
				res=res.replaceAll("\\[", "");
				res=res.replaceAll("]", "");
				return res;
			}
			timeLock++;
		}
		return null;
	}

	/**
	 *
	 */
	public class Permutations {
		public List<List<Integer>> permute() {
			List<List<Integer>> result = new ArrayList<>();
			backtrack(nums, new ArrayList<>(), result);
			return result;
		}
	}

	/**
	 *
	 * @param nums
	 * @param permutation
	 * @param result
	 */
	private void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
		if (permutation.size() == nums.length) {
			result.add(new ArrayList<>(permutation));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (permutation.contains(nums[i])) {
					continue;  // 已经选择过的元素跳过
				}
				permutation.add(nums[i]);
				backtrack(nums, permutation, result);
				permutation.remove(permutation.size() - 1);  // 回溯
			}
		}
	}//private void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> result)
}
