package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __40组合总和II__回溯内判断02 {
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
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> everyComb = new ArrayList<>();
		backTrack(candidates,target,everyComb,res,0);
		return res;

	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @param everyComb
	 * @param res
	 * @param begin
	 */
	private void backTrack(int[] candidates, int target, List<Integer> everyComb, List<List<Integer>> res, int begin) {
		if (target == 0){
			res.add(new ArrayList<Integer>(everyComb));  //避免everyCombine累计
			return;
		}
		if (target<0){
			return;
		}
		for (int  i = begin;i< candidates.length;i++){
			//index代表你每一个全新的判断，来赋的首元素
			if (i > begin && candidates[i] == candidates[i-1]){
				continue;
			}
		}

	}

}
