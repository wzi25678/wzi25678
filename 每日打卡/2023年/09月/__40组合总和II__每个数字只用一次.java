package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __40组合总和II__每个数字只用一次 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @return
	 */
	private  static List<List<Integer>> res = new ArrayList<List<Integer>>();      //记录下最终答案
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> path = new ArrayList<>();
		backTrack(path,candidates,target,0,0);
		return res;
	}

	/**
	 *
	 * @param path
	 * @param candidates
	 * @param target
	 * @param sum
	 * @param index
	 */
	private void backTrack(List<Integer> path, int[] candidates, int target, int sum, int index) {
		if (sum == target){
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i=index;i< candidates.length;i++){
			if (i > index && candidates[i] == candidates[i-1]){
				continue;
			}
			int res = candidates[i]+sum;
			if (res <= target){
				path.add(candidates[i]);
				backTrack(path,candidates,target,res,index+1);
				path.remove(path.size()-1);
			}else {
				break;
			}
		}
	}//private void backTrack(List<Integer> path, int[] candidates, int target, int sum, int index)
}
