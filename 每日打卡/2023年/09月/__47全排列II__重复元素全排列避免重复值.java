package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __47全排列II__重复元素全排列避免重复值 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @return
	 */
	private static boolean [] visited;
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();      //记录下最终答案
		List<Integer> everyCombine = new ArrayList<>();
		visited = new boolean[nums.length];
		Arrays.sort(nums);
		backTrack(nums,res,0,everyCombine);
		return res;
	}//public List<List<Integer>> permuteUnique(int[] nums)

	/**
	 *
	 * @param nums
	 * @param res
	 * @param index
	 * @param everyCombine
	 */
	private void backTrack(int[] nums, List<List<Integer>> res, int index, List<Integer> everyCombine) {
		if (index == nums.length){
			res.add(new ArrayList<>(everyCombine));
			return;
		}
		for (int i=0;i< nums.length;i++){
			//开始尝试避免重复
			if (visited[i] ||(i>0) && nums[i] == nums[i-1] && !visited[i-1]){
				continue;
			}
			everyCombine.add(nums[i] );
			visited[i] = true;
			backTrack(nums,res,index+1,everyCombine);
			visited[i] = false;
			everyCombine.remove(everyCombine.size()-1);
		}
	}//private void backTrack
}
