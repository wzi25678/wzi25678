package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __40组合总和II__AC哥 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}
	private  List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> path_everyComb = new ArrayList<>();
		backTrack(path_everyComb,candidates,target,0,0);
		return res;
	}

	/**
	 *
	 * @param path_everyComb
	 * @param candidates
	 * @param target
	 * @param sum
	 * @param begin
	 */
	private void backTrack(List<Integer> path_everyComb, int[] candidates, int target, int sum, int begin) {
		if (sum == target){
			res.add(new ArrayList<>(path_everyComb));
			return;
		}
		for (int i = begin;i<candidates.length;i++){
			if (i>begin && candidates[i] == candidates[i-1]){
				continue;
			}
			int res = candidates[i] + sum;
			if (res <= target){
				path_everyComb.add(candidates[i]);
				backTrack(path_everyComb,candidates,target,res,i+1);
				path_everyComb.remove(path_everyComb.size()-1);
			}else {
				break;
			}
		}
	}
}
